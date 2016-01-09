package insurance.price;

import insurance.price.model.ModelWithFee;

import java.util.List;

public class PricingProcess<T extends ModelWithFee> {

	private List<PricingStage> pricingStages;
	
	public void launch(T businessModel){
		if(pricingStages != null){
			for(PricingStage stage : pricingStages){
				stage.doPricing(businessModel);
			}
		}
	}

	public void setPricingStages(List<PricingStage> pricingStages) {
		this.pricingStages = pricingStages;
	}
	
}
