package insurance.price.model;

import insurance.price.Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingModel {

	private Map<String,Object> factors = new HashMap<String,Object>();
	private Map<String,BigDecimal> result = new HashMap<String,BigDecimal>();
	private Calculator calculator;
	private boolean isRedy;
	private ModelWithFee refObject;
	private Integer source;
	
	private List<PricingModel> subRatingModels = new ArrayList<PricingModel>();
	
	public Map<String, Object> getFactors() {
		return factors;
	}
	public void setFactors(Map<String, Object> factors) {
		this.factors = factors;
	}
	public Map<String, BigDecimal> getResult() {
		return result;
	}
	public void setResult(Map<String, BigDecimal> result) {
		this.result = result;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public boolean isRedy() {
		return isRedy;
	}
	public void setRedy(boolean isRedy) {
		this.isRedy = isRedy;
	}
	public List<PricingModel> getSubRatingModels() {
		return subRatingModels;
	}
	public void setSubRatingModels(List<PricingModel> subRatingModels) {
		this.subRatingModels = subRatingModels;
	}
	public ModelWithFee getRefObject() {
		return refObject;
	}
	public void setRefObject(ModelWithFee refObject) {
		this.refObject = refObject;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}

	
}
