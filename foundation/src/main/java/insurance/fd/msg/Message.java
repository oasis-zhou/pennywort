package insurance.fd.msg;

import java.io.Serializable;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2801619426862892240L;
	private Object messageBody;

	public Message(Object msg){
		this.messageBody = msg;
	}
	
	public Object getMessageBody() {
		return messageBody;
	}
	
}
