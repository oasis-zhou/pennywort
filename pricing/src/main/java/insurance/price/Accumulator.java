package insurance.price;

import insurance.price.model.PricingModel;

public interface Accumulator {

	public void accumulate(PricingModel model);
}
