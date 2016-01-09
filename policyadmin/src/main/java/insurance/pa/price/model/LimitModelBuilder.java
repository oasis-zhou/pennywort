package insurance.pa.price.model;

import insurance.fd.utils.ObjFieldUtil;
import insurance.pa.model.Coverage;
import insurance.pa.model.Insured;
import insurance.pa.model.Policy;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.util.List;

public class LimitModelBuilder implements PricingModelBuilder<Policy> {

	private Calculator calculator;

	@Override
	public PricingModel build(Policy policy){

		PricingModel root = new PricingModel();
		root.setRefObject(policy);
		root.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(policy));
		
		List<Insured> insureds = policy.getInsureds();

		for(Insured insured : insureds){

			PricingModel iModel = new PricingModel();
			iModel.setRefObject(insured);
			iModel.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(insured));
			root.getSubRatingModels().add(iModel);

			List<Coverage> coverages = insured.getCoverages();

			for(Coverage coverage : coverages){

				if(coverage.getLimit() != null ){
					PricingModel cModel = new PricingModel();
					cModel.setRefObject(coverage);
					cModel.getFactors().putAll(root.getFactors());
					cModel.getFactors().putAll(iModel.getFactors());
					cModel.getFactors().putAll(ObjFieldUtil.getFieldValueByFieldSpecCode(coverage));
					
					cModel.getFactors().put(PricingConstant.LIMIT_FACTOR, coverage.getLimit());
					cModel.setCalculator(calculator);
					iModel.getSubRatingModels().add(cModel);
					
				}
			}
		}

		return root;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
