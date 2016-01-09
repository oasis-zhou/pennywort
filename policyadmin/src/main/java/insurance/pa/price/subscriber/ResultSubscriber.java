package insurance.pa.price.subscriber;

import insurance.price.AbstractSubscriber;
import insurance.price.model.FeeItem;
import insurance.price.model.ModelWithFee;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultSubscriber extends AbstractSubscriber {

	private static Logger logger = LoggerFactory.getLogger(ResultSubscriber.class);
	
	public void processResult(PricingModel model){
		
		Map<String,BigDecimal> r = model.getResult();
		logger.debug("Result ==" + r + "\n");
		
		ModelWithFee ref = model.getRefObject();
		if(ref != null){
			List<FeeItem> fees = ref.getFee().getItems();

			Map<String,BigDecimal> result = model.getResult();
			Iterator<String> itr = result.keySet().iterator();
			while(itr.hasNext()){
				String key = itr.next();
				FeeItem fee = getFee(fees,key);
				if(fee == null){
					FeeItem f = new FeeItem();
					f.setSource(model.getSource());
					f.setFeeType(key);
					f.setAmount(result.get(key));
					fees.add(f);
				}else{
					fee.setAmount(result.get(key));
				}
			}
		}
		
		List<PricingModel> subModels = model.getSubRatingModels();
		if(subModels != null){
			for(PricingModel sub : subModels){
				processResult(sub);
			}
		}
		
		
	}

	private FeeItem getFee(List<FeeItem> fees, String feeType){

		for(FeeItem fee : fees){
			if(fee.getFeeType().equals(feeType))
				return fee;
		}

		return null;
	}
}
