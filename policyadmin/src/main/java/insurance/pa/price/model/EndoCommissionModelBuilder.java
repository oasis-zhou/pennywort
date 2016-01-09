package insurance.pa.price.model;

import insurance.cn.ds.ChannelService;
import insurance.cn.model.CommissionSpec;
import insurance.cn.model.enums.CommissionCalType;
import insurance.pa.model.Endorsement;
import insurance.pa.model.Policy;
import insurance.pa.newbiz.PolicyRepository;
import insurance.pd.ds.ProductService;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.ProductSpec;
import insurance.pd.model.enums.FormulaAim;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.PricingUtils;
import insurance.price.model.Fee;
import insurance.price.model.FeeItem;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EndoCommissionModelBuilder implements PricingModelBuilder<Endorsement> {

	private Calculator calculator;

	@Autowired
	private PolicyRepository policyService;

	@Autowired
	private PricingUtils ratingUtils;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ChannelService channelService;

	@Override
	public PricingModel build(Endorsement bizObject){

		PricingModel root = new PricingModel();
		root.setRefObject(bizObject);
		root.setSource(PricingConstant.FEE_SOURCE_ENDO_COMMISSION);

		Fee feeRoot = bizObject.getFee();
		root.setRefObject(feeRoot);

		//load current policy
		Policy policy = policyService.loadPolicy(bizObject.getPolicyId());
		String productId = policy.getProductId();
		
		CommissionSpec comm = channelService.findCommissionSpec(policy.getChannelId(), productId);

		List<Fee> iefees = feeRoot.getSubFees();

		for(Fee iefee : iefees){

			PricingModel iModel = new PricingModel();
			iModel.setRefObject(iefee);
			iModel.setSource(PricingConstant.FEE_SOURCE_ENDO_COMMISSION);

			root.getSubRatingModels().add(iModel);

			List<Fee> cefees = iefee.getSubFees();

			for(Fee cefee : cefees){

				PricingModel cModel = new PricingModel();
				cModel.setRefObject(cefee);
				cModel.setSource(PricingConstant.FEE_SOURCE_ENDO_COMMISSION);
				
				if(comm.getIsRealTime()){
					BigDecimal rate =  BigDecimal.ZERO;
					if(comm.getCalculationType().equals(CommissionCalType.RATE.getId())){
						rate = comm.getValue();
						cModel.getFactors().put(PricingConstant.COMMISSION_RATE_FACTOR, rate);
					}else{
						cModel.getFactors().put(PricingConstant.FIX_COMMISSION_FACTOR, comm.getValue());
					}

					List<FormulaSpec> formulas = findFormula(productId);
					cModel.getFactors().put(PricingConstant.MULTI_FORMULA_FACTOR, formulas);

					FeeItem cfee = getPremium(cefee.getFee().getItems());	
					if(cfee != null)
						cModel.getFactors().put(PricingConstant.PREMIUM_ANP_FACTOR, cfee.getAmount());

					cModel.setCalculator(calculator);

					iModel.getSubRatingModels().add(cModel);
				}
			}
		}
		return root;
	}

	private FeeItem getPremium(List<FeeItem> fees) {
		for(FeeItem fee : fees){
			if(fee.getFeeType().equals(PricingConstant.FEE_TYPE_ANP) && fee.getSource() == PricingConstant.FEE_SOURCE_ENDO_PREMIUM){
				return  fee;
			}
		}

		return null;
	}

	private List<FormulaSpec> findFormula(String productId) {
		List<FormulaSpec> formulas = new ArrayList<FormulaSpec>();
		ProductSpec productSpec = productService.findProduct(productId);
		if(productSpec.getFormulas() != null){
			for(FormulaSpec f : productSpec.getFormulas()){
				if(f.getAim().equals(FormulaAim.COMMISSION.getId())){
					formulas.add(f);
				}
			}
		}

		return formulas;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
