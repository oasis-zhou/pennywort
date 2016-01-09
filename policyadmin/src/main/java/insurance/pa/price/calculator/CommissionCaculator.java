package insurance.pa.price.calculator;

import insurance.pd.ds.ProductService;
import insurance.pd.model.FormulaSpec;
import insurance.price.Calculator;
import insurance.price.FmsService;
import insurance.price.PricingConstant;
import insurance.price.RoundingUtils;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class CommissionCaculator implements Calculator {

	@Autowired
	private FmsService fmsService;
	
	@Autowired
	private ProductService productService;

	@Override
	public void calculate(PricingModel model) {

		Map<String,Object> factors = model.getFactors();

		List<FormulaSpec> formulas = (List<FormulaSpec>)factors.get(PricingConstant.MULTI_FORMULA_FACTOR);

		if(formulas != null){
			for(FormulaSpec formula : formulas){

				if(factors.get(PricingConstant.FIX_COMMISSION_FACTOR) != null){
					BigDecimal result = (BigDecimal)factors.get(PricingConstant.FIX_COMMISSION_FACTOR);
					result = RoundingUtils.round(result,null);
					model.getResult().put(PricingConstant.FEE_TYPE_COMMISSION, result);
				}else{
					//call formula service to calculate commission
					Map result = fmsService.evalWithFormula(formula,factors);
					Map r = RoundingUtils.round(result,null);
					model.getResult().putAll(r);
				}	
			}
		}
	}

}
