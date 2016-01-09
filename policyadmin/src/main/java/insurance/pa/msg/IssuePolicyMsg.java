package insurance.pa.msg;

import insurance.fd.msg.DomainMessage;

public class IssuePolicyMsg extends DomainMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6536036083328257852L;

	public IssuePolicyMsg(String aggregateId,Object msg){
		super(aggregateId,msg);
	}
}
