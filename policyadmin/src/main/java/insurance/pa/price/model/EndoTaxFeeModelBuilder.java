package insurance.pa.price.model;

import insurance.pa.model.Endorsement;
import insurance.pa.model.Policy;
import insurance.pa.newbiz.PolicyRepository;
import insurance.pd.ds.ProductService;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.ProductSpec;
import insurance.pd.model.enums.FormulaAim;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.model.FeeItem;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EndoTaxFeeModelBuilder implements PricingModelBuilder<Endorsement> {

	private Calculator calculator;

	@Autowired
	private PolicyRepository policyService;
	
	@Autowired
	private ProductService productService;

	@Override
	public PricingModel build(Endorsement bizObject){

		PricingModel root = new PricingModel();
		root.setRefObject(bizObject);
		root.setSource(PricingConstant.FEE_SOURCE_ENDO_TAXFEE);
		root.setCalculator(calculator);

		//load current policy
		Policy policy = policyService.loadPolicy(bizObject.getPolicyId());
		String productId = policy.getProductId();

		List<FeeItem> fees = bizObject.getFee().getItems();
		for(FeeItem fee : fees){
			if(fee.getFeeType().equals(PricingConstant.FEE_TYPE_ANP) && fee.getSource() == PricingConstant.FEE_SOURCE_ENDO_PREMIUM){
				root.getFactors().put(PricingConstant.PREMIUM_ANP_FACTOR, fee.getAmount());
			}
		}
		
		List<FormulaSpec> formulas = findFormula(productId);
		root.getFactors().put(PricingConstant.MULTI_FORMULA_FACTOR, formulas);

		return root;
	}
	
	private List<FormulaSpec> findFormula(String productId) {
		List<FormulaSpec> formulas = new ArrayList<FormulaSpec>();
		ProductSpec productSpec = productService.findProduct(productId);
		if(productSpec.getFormulas() != null){
			for(FormulaSpec f : productSpec.getFormulas()){
				if(f.getAim().equals(FormulaAim.TAX_FEE.getId())){
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
