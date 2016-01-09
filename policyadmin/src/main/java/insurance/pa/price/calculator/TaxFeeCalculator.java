package insurance.pa.price.calculator;

import insurance.pd.model.FormulaSpec;
import insurance.price.Calculator;
import insurance.price.FmsService;
import insurance.price.PricingConstant;
import insurance.price.RoundingUtils;
import insurance.price.model.PricingModel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class TaxFeeCalculator implements Calculator {

	@Autowired
	private FmsService fmsService;

	@Override
	public void calculate(PricingModel model) {

		Map<String,Object> factors = model.getFactors();
		
		List<FormulaSpec> formulas = (List<FormulaSpec>)factors.get(PricingConstant.MULTI_FORMULA_FACTOR);

		if(formulas != null){
			for(FormulaSpec formula : formulas){

				//call formula service to calculate tax fee
				Map result = fmsService.evalWithFormula(formula,factors);
				
				Map r = RoundingUtils.round(result,null);

				model.getResult().putAll(r);
			}
		}
	}
	
}
