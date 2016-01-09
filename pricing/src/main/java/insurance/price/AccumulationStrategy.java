package insurance.price;

import insurance.price.model.PricingModel;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class AccumulationStrategy implements PricingStrategy {

	private Accumulator accumulator;
	
	public Observable<PricingModel> execute(PricingModel model){
		
		return accumulate(model);
	}
	
	private Observable<PricingModel> accumulate(final PricingModel model){

		Calculator calculator = model.getCalculator();
		if(calculator != null){
			calculator.calculate(model);
		}
		model.setRedy(true);	

		Observable<PricingModel> o = Observable.just(model);

		if(model.getSubRatingModels().size() > 0){
			Observable.from(model.getSubRatingModels()).flatMap(new Func1<PricingModel,Observable<PricingModel>>(){
				@Override
				public Observable<PricingModel> call(PricingModel sub) {						
					return accumulate(sub);
				}
			}).all(new Func1<PricingModel,Boolean>(){
				@Override
				public Boolean call(PricingModel sub) {	

					return sub.isRedy();
				}
			}).subscribe(new Action1<Boolean>(){

				@Override
				public void call(Boolean redy) {	
					if(redy){
						accumulator.accumulate(model);
					}
				}
			});
		}

		return o;

	}

	public void setAccumulator(Accumulator accumulator) {
		this.accumulator = accumulator;
	}
	
}
