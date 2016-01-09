package insurance.price;

import insurance.price.model.PricingModel;
import rx.Observable;



public interface PricingStrategy {

	public Observable<PricingModel> execute(PricingModel model);
}
