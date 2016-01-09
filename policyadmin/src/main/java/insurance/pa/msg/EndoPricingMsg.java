package insurance.pa.msg;

import insurance.fd.msg.DomainMessage;

public class EndoPricingMsg extends DomainMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2542475488893590833L;

	public EndoPricingMsg(String aggregateId,Object msg){
		super(aggregateId,msg);
	}
}
