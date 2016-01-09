package insurance.price;

import org.junit.Test;

import insurance.AbstractTest;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaTest extends AbstractTest{

	@Test
	public void test1(){

		final RxTestModel model = new RxTestModel();
		model.setId(1);
		model.setName("TOM");
		model.setAddress("Shanghai");

		Observable<RxTestModel> o = exportDate(model);

		o.subscribe(new TestSubscriber());
	}


	class TestSubscriber extends Subscriber<RxTestModel>{		
		@Override
		public void onNext(RxTestModel model) { 
			System.out.println("Subscriber model address::" + model.getAddress());
		}
		@Override
		public void onCompleted() { }
		@Override
		public void onError(Throwable e) { 
			System.out.println("Subscriber error");
		}
	}

	private Observable<RxTestModel> exportDate(final RxTestModel model){

		Observable<RxTestModel> o = Observable.just(model);

		o.map(new Func1<RxTestModel,String>(){
			@Override
			public String call(RxTestModel m) {		
				String str = m.getName() + " " + m.getAddress();
				System.out.println("Map data::" + str);
				return str;
			}
		}).map(new Func1<String,String>(){
			@Override
			public String call(String s) {		
				String str = s.substring(3) + " Pudong";
				System.out.println("Record call log!");
				if(s.substring(4).equals("Shanghai"))
					throw new RuntimeException();
				return str;
			}
		}).retry(2)
		.subscribe(new Action1<String>(){
			@Override
			public void call(String result) {	
				model.setAddress(result);
				System.out.println("Update data info==" + model.getAddress());
			}
		});

		return o;
	}
}
