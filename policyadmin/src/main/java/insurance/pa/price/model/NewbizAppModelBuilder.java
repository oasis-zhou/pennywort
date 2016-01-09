package insurance.pa.price.model;

import insurance.pa.model.Policy;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.model.FeeItem;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.util.List;

public class NewbizAppModelBuilder implements PricingModelBuilder<Policy> {

	private Calculator calculator;

	@Override
	public PricingModel build(Policy policy){
		
		PricingModel root = new PricingModel();
		root.setRefObject(policy);
		root.setSource(PricingConstant.FEE_SOURCE_NEWBIZ_PREMIUM);
		root.setCalculator(calculator);
		
		List<FeeItem> fees = policy.getFee().getItems();
		for(FeeItem fee : fees){	
			if(fee.getFeeType().equals(PricingConstant.FEE_TYPE_ANP) || fee.getSource() == PricingConstant.FEE_SOURCE_NEWBIZ_TAXFEE){
			root.getFactors().put(fee.getFeeType(), fee.getAmount());
			}
		}
		
		return root;
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
