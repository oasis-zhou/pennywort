package insurance.price;

import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;


public class DistributionStrategy implements PricingStrategy {

	private Distributor distributor;
	
	@Override
	public Observable<PricingModel> execute(PricingModel model) {
		
		Map<String, Object> factors = model.getFactors();
		
		Iterator i = factors.keySet().iterator();
		while (i.hasNext()) {            	  
			String valueKey = (String) i.next();
			if(!valueKey.equals(PricingConstant.DISTRIBUTION_FACTOR)){
				BigDecimal distributionValue = (BigDecimal) factors.get(valueKey);
				model.getResult().put(valueKey, distributionValue);
			}
		}
		
		return distribute(model);
	}
	
	private Observable<PricingModel> distribute(final PricingModel model){
		
		Observable<PricingModel> o = Observable.just(model);

		if(model.getSubRatingModels().size() > 0){
			
			distributor.distribute(model);
			
			Observable.from(model.getSubRatingModels()).flatMap(new Func1<PricingModel,Observable<PricingModel>>(){
				@Override
				public Observable<PricingModel> call(PricingModel sub) {						
					return distribute(sub);
				}
			}).subscribe();
		}

		return o;

	}
	
	
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

}
