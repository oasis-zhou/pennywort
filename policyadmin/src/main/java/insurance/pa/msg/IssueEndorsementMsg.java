package insurance.pa.msg;

import insurance.fd.msg.DomainMessage;

public class IssueEndorsementMsg extends DomainMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6536036083328257852L;

	public IssueEndorsementMsg(String aggregateId,Object msg){
		super(aggregateId,msg);
	}
}
