package insurance.fd.actor;

import insurance.fd.model.BaseModel;
import insurance.fd.msg.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorContext;
import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;

public abstract class AggregateRoot<T extends BaseModel> extends UntypedActor {

	private static Logger logger = LoggerFactory.getLogger(AggregateRoot.class);
	
	@Override
	public void onReceive(Object message) throws Exception {
		logger.debug("Message on receive \n");
		if(message instanceof Message){
//			getContext().setReceiveTimeout(Duration.create("30 second"));
			
			handle(message,context());
		}else if (message instanceof ReceiveTimeout) { 		
//			 getContext().setReceiveTimeout(Duration.Undefined());
			 
	        throw new RuntimeException("received timeout"); 
	    }else{
	    	unhandled(message);
	    }
	}
	
	public abstract void handle(Object msg,ActorContext context);

}
