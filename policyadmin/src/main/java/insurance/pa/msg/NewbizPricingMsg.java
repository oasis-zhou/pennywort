package insurance.pa.msg;

import insurance.fd.msg.DomainMessage;

public class NewbizPricingMsg extends DomainMessage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -472129432524736687L;
	
	public NewbizPricingMsg(String aggregateId,Object msg){
		super(aggregateId,msg);
	}
	
}
