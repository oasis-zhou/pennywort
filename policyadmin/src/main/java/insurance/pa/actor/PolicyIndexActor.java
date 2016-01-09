package insurance.pa.actor;

import insurance.pa.model.Policy;
import insurance.pa.msg.IssuePolicyMsg;
import insurance.pa.newbiz.PolicyRepository;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;

@Named("PolicyIndexActor")
@Component
@Scope(value = "prototype")
public class PolicyIndexActor extends UntypedActor {

	@Autowired
	private PolicyRepository policyRepository;
	
	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof IssuePolicyMsg){
			policyRepository.savePolicyIndex((Policy)((IssuePolicyMsg)message).getMessageBody());
		}else if (message instanceof ReceiveTimeout) { 		
	        throw new RuntimeException("received timeout"); 
	    }else{
	    	unhandled(message);
	    }

	}

}
