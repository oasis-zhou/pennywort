package insurance.pa.price.subscriber;

import insurance.pa.model.Coverage;
import insurance.pa.model.Insured;
import insurance.pa.model.Policy;
import insurance.price.AbstractSubscriber;
import insurance.price.PricingConstant;
import insurance.price.model.ModelWithFee;
import insurance.price.model.PricingModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LimitSubscriber extends AbstractSubscriber {

	private static Logger logger = LoggerFactory.getLogger(LimitSubscriber.class);
	
	public void processResult(PricingModel model){
		
		Map<String,BigDecimal> r = model.getResult();
		logger.debug("Result ==" + r + "\n");
		
		ModelWithFee ref = model.getRefObject();
		if(ref != null){
			Map<String,BigDecimal> result = model.getResult();
			
			if(ref instanceof Policy){
				
				((Policy)ref).setAOALimitAmount(result.get(PricingConstant.AOA_LIMIT_AMOUNT));
				((Policy)ref).setAOPLimitAmount(result.get(PricingConstant.AOP_LIMIT_AMOUNT));
				
			}else if(ref instanceof Insured){
				
				((Insured)ref).setAOALimitAmount(result.get(PricingConstant.AOA_LIMIT_AMOUNT));
				((Insured)ref).setAOPLimitAmount(result.get(PricingConstant.AOP_LIMIT_AMOUNT));
				
			}else if(ref instanceof Coverage){
				
				((Coverage)ref).setAOALimitAmount(result.get(PricingConstant.AOA_LIMIT_AMOUNT));
				((Coverage)ref).setAOPLimitAmount(result.get(PricingConstant.AOP_LIMIT_AMOUNT));
			}
		}
		
		List<PricingModel> subModels = model.getSubRatingModels();
		if(subModels != null){
			for(PricingModel sub : subModels){
				processResult(sub);
			}
		}
	}

}
