package insurance.pa.price.calculator;

import insurance.pa.model.Limit;
import insurance.pd.model.FormulaSpec;
import insurance.pd.model.enums.IndemnityType;
import insurance.price.Calculator;
import insurance.price.FmsService;
import insurance.price.PricingConstant;
import insurance.price.RoundingUtils;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class LimitCalculator implements Calculator {

	@Autowired
	private FmsService fmsService;

	//Amount Per Occurrence
	public static final String APO = "${limitAmount}";
	//Amount Per Unit Per Occurrence
	public static final String APUPO = "${unitAmount}/${numberOfUnit} ${unitType}";
	//Amount Per Unit Per Occurrence+Max Amount
	public static final String APUPO_MA = "${unitAmount}/${numberOfUnit} ${unitType} max ${maxUnitAmount}";
	//Amount Per Unit Per Occurrence+Max Number
	public static final String APUPO_MN = "${unitAmount}/${numberOfUnit} ${unitType} max ${maxNumberOfUnit}";
	//By formula
	public static final String FORMULA = "${limitFormula}";


	@Override
	public void calculate(PricingModel model) {

		Limit limit = (Limit)model.getFactors().get(PricingConstant.LIMIT_FACTOR);

		if(limit != null){

			String pattern = limit.getPattern();
			
		

			Map<String, Object> factorTable = new HashMap<String, Object>();
			factorTable.putAll(model.getFactors());
			
			Map limitAmountM = RoundingUtils.round(getValue(limit,factorTable),null);

			if(APO.equals(pattern)){
				model.getResult().putAll(limitAmountM);
			}else if(APUPO.equals(pattern)){
				model.getResult().putAll(limitAmountM);
			}else if(APUPO_MA.equals(pattern)){
				model.getResult().putAll(limitAmountM);
			}else if(APUPO_MN.equals(pattern)){
				model.getResult().putAll(limitAmountM);
			}else if(FORMULA.equals(pattern)){
				model.getResult().putAll(limitAmountM);
			}
		}

	}

	public Map getValue(Limit limit, Map<String, Object> factorTable){
		
		Map<String,BigDecimal> result = new HashMap<String,BigDecimal>();
		String pattern = limit.getPattern();
		
		
		String limitKey = PricingConstant.AOA_LIMIT_AMOUNT;
		String limitType = limit.getIndemnityType();
		if(limitType != null && !limitType.equals(IndemnityType.AOA.getId())){
			limitKey = PricingConstant.AOP_LIMIT_AMOUNT;
		}
		BigDecimal amount = BigDecimal.ZERO;
		
		if(APO.equals(pattern)){
			BigDecimal limitAmount = limit.getLimitAmount();
			if(limitAmount != null){
				amount = limitAmount;
				result.put(limitKey, amount);
			}
		}else if(APUPO.equals(pattern)){
			BigDecimal unitAmount = limit.getUnitAmount();
			BigDecimal numberOfUnit = limit.getNumberOfUnit();
			String unitType = limit.getUnitType();

			amount = unitAmount;
			result.put(limitKey, amount);
			
		}else if(APUPO_MA.equals(pattern)){
			
			BigDecimal maxUnitAmount = limit.getMaxUnitAmount();
			if(maxUnitAmount != null){
				amount = maxUnitAmount;
				result.put(limitKey, amount);
			}
		}else if(APUPO_MN.equals(pattern)){
			BigDecimal unitAmount = limit.getUnitAmount();
			BigDecimal numberOfUnit = limit.getNumberOfUnit();
			BigDecimal maxNumberOfUnit = limit.getMaxNumberOfUnit();
			amount = ((BigDecimal)unitAmount).multiply((BigDecimal) maxNumberOfUnit)
					.divide((BigDecimal) numberOfUnit,50, BigDecimal.ROUND_HALF_UP);
			result.put(limitKey, amount);
		}else if(FORMULA.equals(pattern)){
			String limitFormula = limit.getLimitFormula();
			FormulaSpec f = (FormulaSpec)factorTable.get(PricingConstant.FORMULA_FACTOR);
		
			Map r = fmsService.evalWithFormula(f,factorTable);
			result.putAll(r);
		}
		
		return result;
	}

}
