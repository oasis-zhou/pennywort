package insurance.fd.ratetable.model;

import java.util.HashMap;
import java.util.Map;

public class RateItem {

	private Map<String,RateFactor> rateFactors = new HashMap<String,RateFactor>();
	private Map<String,String> rateValues = new HashMap<String,String>();
	
	public Map<String, RateFactor> getRateFactors() {
		return rateFactors;
	}
	public void setRateFactors(Map<String, RateFactor> rateFactors) {
		this.rateFactors = rateFactors;
	}
	public Map<String, String> getRateValues() {
		return rateValues;
	}
	public void setRateValues(Map<String, String> rateValues) {
		this.rateValues = rateValues;
	}
	
	
}
