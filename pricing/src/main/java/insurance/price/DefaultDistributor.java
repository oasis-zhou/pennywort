package insurance.price;

import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultDistributor implements Distributor {

	@Override
	public void distribute(PricingModel model){

		Map<String, Object> factors = model.getFactors();
		
		List<PricingModel> subModels = model.getSubRatingModels();

		int calCount = 0;
		int subSize = subModels.size();
		BigDecimal percentage = BigDecimal.ZERO;
		percentage = BigDecimal.ONE.divide(new BigDecimal(subSize),50, BigDecimal.ROUND_HALF_UP);
		
		Map sumSubValueM = new HashMap();
		for (PricingModel subModel : subModels) {
			Map<String, Object> subFactors = subModel.getFactors();

			if (calCount != subSize - 1) {
				
				BigDecimal factorValue = (BigDecimal) factors.get(PricingConstant.DISTRIBUTION_FACTOR);
				BigDecimal subFactorValue = (BigDecimal) subFactors.get(PricingConstant.DISTRIBUTION_FACTOR);
				
				if (factorValue != null && factorValue.compareTo(BigDecimal.ZERO) != 0 
						&& subFactorValue != null && subFactorValue.compareTo(BigDecimal.ZERO) != 0) {				
					percentage = subFactorValue.divide(factorValue,50, BigDecimal.ROUND_HALF_UP);
				}

				Iterator itr = factors.keySet().iterator();
				while (itr.hasNext()) {            	  
					String valueKey = (String) itr.next();
					if(!valueKey.equals(PricingConstant.DISTRIBUTION_FACTOR)){
						BigDecimal distributionValue = (BigDecimal) factors.get(valueKey);

						BigDecimal subValue = distributionValue.multiply(percentage);
						subValue = RoundingUtils.round(subValue,null);
						subFactors.put(valueKey, subValue);
						subModel.getResult().put(valueKey, subValue);

						BigDecimal sumSubValue = (BigDecimal) sumSubValueM.get(valueKey);
						if (sumSubValue != null) {
							sumSubValue = sumSubValue.add(subValue);
						} else {
							sumSubValue = subValue;
						}
						sumSubValueM.put(valueKey, sumSubValue);
					}
				}

			} else {
				Iterator itr = factors.keySet().iterator();
				while (itr.hasNext()) {
					String valueKey = (String) itr.next();
					if(!valueKey.equals(PricingConstant.DISTRIBUTION_FACTOR)){
						BigDecimal distributionValue = (BigDecimal) factors.get(valueKey);
						BigDecimal sumSubValue = (BigDecimal) sumSubValueM.get(valueKey);
						if(sumSubValue == null)
							sumSubValue = BigDecimal.ZERO;
						BigDecimal subValue = distributionValue.subtract(sumSubValue);					
						subFactors.put(valueKey, subValue);
						subModel.getResult().put(valueKey, subValue);
					}
				} 

				calCount++;
			}
		}
	}

}
