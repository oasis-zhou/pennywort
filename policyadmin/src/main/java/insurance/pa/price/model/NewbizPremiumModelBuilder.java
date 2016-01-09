package insurance.pa.price.model;

import insurance.fd.utils.ObjFieldUtil;
import insurance.pa.model.Coverage;
import insurance.pa.model.Insured;
import insurance.pa.model.Policy;
import insurance.pd.ds.ProductService;
import insurance.pd.model.CoverageSpec;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.enums.FormulaAim;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class NewbizPremiumModelBuilder implements PricingModelBuilder<Policy> {

	private Calculator calculator;

	@Autowired
	private ProductService productService;

	@Override
	public PricingModel build(Policy policy){

		PricingModel root = new PricingModel();
		root.setRefObject(policy);
		root.setSource(PricingConstant.FEE_SOURCE_NEWBIZ_PREMIUM);

		String productId = policy.getProductId();

		root.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(policy));

		List<Insured> insureds = policy.getInsureds(); 

		for(Insured insured : insureds){

			PricingModel iModel = new PricingModel();
			iModel.setRefObject(insured);
			iModel.setSource(PricingConstant.FEE_SOURCE_NEWBIZ_PREMIUM);
			iModel.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(insured));

			Map<String,Object> ifactors = iModel.getFactors();

			root.getSubRatingModels().add(iModel);

			List<Coverage> coverages = insured.getCoverages();

			for(Coverage coverage : coverages){

				PricingModel cModel = new PricingModel();
				cModel.setRefObject(coverage);
				cModel.setSource(PricingConstant.FEE_SOURCE_NEWBIZ_PREMIUM);
				cModel.getFactors().putAll(root.getFactors());
				cModel.getFactors().putAll(iModel.getFactors());
				cModel.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(coverage));
				if(coverage.getLimit() != null)
					cModel.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(coverage.getLimit()));
				if(coverage.getDeductible() != null)
					cModel.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(coverage.getDeductible()));

				FormulaSpec formula = findFormula(productId,coverage.getCoverageId());
				if(formula != null){
					cModel.setCalculator(calculator);
					cModel.getFactors().put(PricingConstant.FORMULA_FACTOR, formula);
				}

				iModel.getSubRatingModels().add(cModel);

			}
		}

		return root;
	}

	private FormulaSpec findFormula(String productId,String coverageId) {
		FormulaSpec formula = null;
		CoverageSpec coverageSpec = productService.findCoverageSpec(productId, coverageId);
		if(coverageSpec.getFormulas() != null){
			for(FormulaSpec f : coverageSpec.getFormulas()){
				if(f.getAim().equals(FormulaAim.GROSS_PREMIUM.getId())){
					formula = f;
				}
			}
		}

		return formula;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
