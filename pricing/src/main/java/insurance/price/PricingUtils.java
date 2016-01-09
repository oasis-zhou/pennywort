package insurance.price;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class PricingUtils {

	
	public BigDecimal findCommissionRate(Long channelId,String product){
		
		//TODO: set the real params
		BigDecimal rate = BigDecimal.ZERO;
		
		return rate;
	}
}
