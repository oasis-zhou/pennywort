package insurance.pa.price.model;

import insurance.pa.model.Endorsement;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.model.FeeItem;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.util.List;

public class EndoAppModelBuilder implements PricingModelBuilder<Endorsement> {

	private Calculator calculator;

	@Override
	public PricingModel build(Endorsement bizObject){

		PricingModel root = new PricingModel();
		root.setRefObject(bizObject);
		root.setSource(PricingConstant.FEE_SOURCE_ENDO_PREMIUM);
		root.setCalculator(calculator);

		List<FeeItem> fees = bizObject.getFee().getItems();
		for(FeeItem fee : fees){		
			if(fee.getFeeType().equals(PricingConstant.FEE_TYPE_ANP) || fee.getSource() == PricingConstant.FEE_SOURCE_ENDO_TAXFEE){

				root.getFactors().put(fee.getFeeType(), fee.getAmount());
			}
		}

		return root;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}