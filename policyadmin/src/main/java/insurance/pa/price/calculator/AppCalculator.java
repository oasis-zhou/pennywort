package insurance.pa.price.calculator;

import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.RoundingUtils;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class AppCalculator implements Calculator {

	@Override
	public void calculate(PricingModel model) {
		Map<String,Object> factors = model.getFactors();

		BigDecimal APP = BigDecimal.ZERO;
		BigDecimal ANP = (BigDecimal)factors.get(PricingConstant.FEE_TYPE_ANP);

		if(ANP != null)
			APP = APP.add(ANP);

		Iterator itr = factors.keySet().iterator();
		while(itr.hasNext()){
			String feeType = (String)itr.next();
			if(!feeType.equals(PricingConstant.FEE_TYPE_ANP)){

				BigDecimal taxfee = (BigDecimal)factors.get(feeType);

				APP = APP.add(taxfee);
			}
		}

		model.getResult().put(PricingConstant.FEE_TYPE_APP, RoundingUtils.round(APP,null));

	}

}
