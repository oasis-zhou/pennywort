package insurance.msg;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import insurance.AbstractTest;

public class MsgQueueTest extends AbstractTest{

	@Autowired
	private MsgQueueProducer producer;
	
	@Autowired
	private MsgQueueListener listener;
	
	@Test
	public void sendMsg(){
		
		String msg = "Hello Word!";
		
		producer.sendReliable("my-mq-exchange", msg);
		
	}
}
