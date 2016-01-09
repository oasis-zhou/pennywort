package insurance.price;

import insurance.price.model.PricingModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Subscriber;

public abstract class AbstractSubscriber extends Subscriber<PricingModel>{

private static Logger logger = LoggerFactory.getLogger(AbstractSubscriber.class);
	
	@Override
	public void onNext(PricingModel model) { 
		processResult(model);
	}

	@Override
	public void onCompleted() { }

	@Override
	public void onError(Throwable e) { 
		e.printStackTrace();
	}
	
	public abstract void processResult(PricingModel model);
}
