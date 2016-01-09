package insurance.price;

import insurance.price.model.ModelWithFee;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;
import rx.Observable;
import rx.Subscriber;

public class PricingStage<T extends ModelWithFee> {

	private PricingModelBuilder builder;
	private PricingStrategy strategy;
	private Subscriber subscriber;
	
	public void doPricing(T businessModel){
		PricingModel model = builder.build(businessModel);
		
		Observable<PricingModel> ob = strategy.execute(model);
		ob.subscribe(subscriber);
	}

	public void setBuilder(PricingModelBuilder builder) {
		this.builder = builder;
	}

	public void setStrategy(PricingStrategy strategy) {
		this.strategy = strategy;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	
	
}
