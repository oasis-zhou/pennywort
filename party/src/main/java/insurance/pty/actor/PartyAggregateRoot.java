package insurance.pty.actor;

import insurance.fd.actor.AggregateRoot;
import insurance.pty.PartyRepository;
import insurance.pty.model.Party;
import insurance.pty.msg.SavePartyMsg;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.ActorContext;

@Named("PartyAggregateRoot")
@Component
@Scope(value = "prototype")
public class PartyAggregateRoot  extends AggregateRoot<Party>{

	private static Logger logger = LoggerFactory.getLogger(PartyAggregateRoot.class);
	
	@Autowired
	private PartyRepository repository;
	
	@Override
	public void handle(Object msg, ActorContext context) {

		logger.debug("Party aggregate handle message \n");
		try{
			String rMsg = null;
			Method m = getClass().getDeclaredMethod("apply", msg.getClass());
			m.setAccessible(true);
			m.invoke(this, msg);
		}catch(NoSuchMethodException e){
			throw new RuntimeException(e);
		}catch(IllegalArgumentException e){
			throw new RuntimeException(e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}catch(InvocationTargetException e){
			throw new RuntimeException(e);
		}
		//		context.sender().tell(rMsg, null);
	}
	
	protected void apply(SavePartyMsg msg){
		Party party = (Party)msg.getMessageBody();
		
		repository.savePartyRole(party);
		
	}

}
