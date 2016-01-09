package insurance.price;

import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultAccumulator implements Accumulator {

	@Override
	public void accumulate(PricingModel model) {

		Map<String, BigDecimal> parentValue = model.getResult();

		List<PricingModel> subModels = model.getSubRatingModels();

		for(PricingModel subModel : subModels){

			Map<String, BigDecimal> childValue = subModel.getResult();

			Iterator itr = childValue.keySet().iterator();
			while (itr.hasNext()) {
				String key = (String) itr.next();
				BigDecimal pAmount = (BigDecimal) parentValue.get(key);
				BigDecimal cAmount = (BigDecimal) childValue.get(key);
				if (pAmount != null) {
					pAmount = pAmount.add(cAmount);
					parentValue.put(key, pAmount);
				} else {
					parentValue.put(key, cAmount);
				}
			}
		}
	}

}
