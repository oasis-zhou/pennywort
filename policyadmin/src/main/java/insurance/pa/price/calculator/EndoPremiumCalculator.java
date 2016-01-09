package insurance.pa.price.calculator;

import insurance.pd.ds.ProductService;
import insurance.pd.model.FormulaSpec;
import insurance.price.Calculator;
import insurance.price.FmsService;
import insurance.price.PricingConstant;
import insurance.price.RoundingUtils;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class EndoPremiumCalculator implements Calculator {

	private Map<String, String> formulaM;

	@Autowired
	private FmsService fmsService;
	
	@Autowired
	private ProductService productService;

	@Override
	public void calculate(PricingModel model) {
		Map<String,Object> factors = model.getFactors();

		Integer type = (Integer)factors.get(PricingConstant.ENDORSEMENT_TYPE_FACTOR);

		if(formulaM != null && type != null){
			String formulaId = formulaM.get(type.toString());

			FormulaSpec formula = productService.findFormula(formulaId);

			//TODO call formula service to calculate endorsement premium
			Map result = fmsService.evalWithFormula(formula,factors);
		
			Map r = RoundingUtils.round(result,null);

			model.getResult().putAll(r);
		}

	}

	public void setFormulaM(Map<String, String> formulaM) {
		this.formulaM = formulaM;
	}

}
