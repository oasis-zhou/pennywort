package insurance.fd.msg;

public class DomainMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7765245055709384236L;
	private String aggregateId;
	
	public DomainMessage(String aggregateId,Object msg){
		super(msg);
		this.aggregateId = aggregateId;
	}

	public String getAggregateId() {
		return aggregateId;
	}
	
}
