package insurance.pty.msg;

import insurance.fd.msg.DomainMessage;

public class SavePartyMsg extends DomainMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2925452053916040749L;

	public SavePartyMsg(String aggregateId,Object msg){
		super(aggregateId,msg);
	}
}
