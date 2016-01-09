package insurance.pa.price.calculator;

import insurance.price.Accumulator;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LimitAccumulator implements Accumulator {

	@Override
	public void accumulate(PricingModel model) {
		Map<String, BigDecimal> parentValue = model.getResult();

		List<PricingModel> subModels = model.getSubRatingModels();

		Map<String, BigDecimal> pAmountM = new HashMap<String, BigDecimal>();
		
		for(PricingModel subModel : subModels){

			Map<String, BigDecimal> childValue = subModel.getResult();

			Iterator itr = childValue.keySet().iterator();
			while (itr.hasNext()) {
				String key = (String) itr.next();
				BigDecimal pAmount = (BigDecimal) parentValue.get(key);
				BigDecimal cAmount = (BigDecimal) childValue.get(key);
				if (pAmount == null && cAmount != null) {
					
					BigDecimal sumAmount = pAmountM.get(key);
					
					if(sumAmount != null){
						sumAmount = sumAmount.add(cAmount);
						pAmountM.put(key, sumAmount);
					}else{
						pAmountM.put(key, cAmount);
					}
					
				}
			}
		}
		
		parentValue.putAll(pAmountM);

	}

}
