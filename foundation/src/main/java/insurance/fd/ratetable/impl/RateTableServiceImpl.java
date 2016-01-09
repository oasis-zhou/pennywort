package insurance.fd.ratetable.impl;

import insurance.fd.ratetable.RateTableService;
import insurance.fd.ratetable.model.RateFactor;
import insurance.fd.ratetable.model.RateItem;
import insurance.fd.ratetable.model.RateTable;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RateTableServiceImpl implements RateTableService {

	@Override
	public Map<String, String> findRate(RateTable table,Map<String, String> factors) {

		Map<String,String> rateValues = null;
		boolean isMatchItem = true;
		List<RateItem> items = table.getItems();
		for(RateItem item : items){
		
			Map<String,RateFactor> itemFactors = item.getRateFactors();
			for(Entry<String,String> entry : factors.entrySet()){
				if(itemFactors.containsKey(entry.getKey())){
					RateFactor factor = itemFactors.get(entry.getKey());
					if(!factor.match(entry.getValue())){
						isMatchItem = false;
						break;
					}
				}else{
					isMatchItem = false;
					break;
				}
			}
			if(isMatchItem){
				rateValues = item.getRateValues();
				break;
			}
		}
		
		if(!isMatchItem)
			throw new RuntimeException("20001");
		return rateValues;
	}

}
