package insurance.pa.price.calculator;

import insurance.pa.model.Coverage;
import insurance.pd.model.FormulaSpec;
import insurance.price.Calculator;
import insurance.price.FmsService;
import insurance.price.PricingConstant;
import insurance.price.RoundingUtils;
import insurance.price.model.ModelWithFee;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NewbizPremiumCalculator implements Calculator {

	private static Logger logger = LoggerFactory.getLogger(NewbizPremiumCalculator.class);
	
	@Autowired
	private FmsService fms;

	@Override
	public void calculate(PricingModel model) {

		Map<String,Object> factors = model.getFactors();
	
		
		
		if(factors.get(PricingConstant.FIX_PREMIUM_FACTOR) != null){
			BigDecimal result = (BigDecimal)factors.get(PricingConstant.FIX_PREMIUM_FACTOR);
			
			result = RoundingUtils.round(result,null);
			
			model.getResult().put(PricingConstant.FEE_TYPE_SGP, result);
			model.getResult().put(PricingConstant.FEE_TYPE_AGP, result);
			model.getResult().put(PricingConstant.FEE_TYPE_SNP, result);
			model.getResult().put(PricingConstant.FEE_TYPE_ANP, result);
		}else{
			FormulaSpec formula = (FormulaSpec) factors.get(PricingConstant.FORMULA_FACTOR);
			Map result = fms.evalWithFormula(formula,factors);
			
			Map r = RoundingUtils.round(result,null);
			
			model.getResult().putAll(r);
		}
		
		ModelWithFee ref = model.getRefObject();
		
		if(ref instanceof Coverage){
			String code = ((Coverage)ref).getCode();	
			logger.debug("Coverage " + code +  " Premium Result ==" + model.getResult() + "\n");
		}
		
		
		

		

	}

}
