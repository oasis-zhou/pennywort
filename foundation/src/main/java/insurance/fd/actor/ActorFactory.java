package insurance.fd.actor;

import insurance.fd.conf.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akka.actor.ActorContext;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

@Service
public class ActorFactory {
	
	@Autowired
	private SpringExtension sExtension;
	
	@Autowired
	private ActorSystem actorSystem;
	
	public ActorRef createActor(String actorName){
		
		ActorRef actor = actorSystem.actorOf(sExtension.props(actorName), actorName);
	
		return actor;
	}
	
	public ActorRef createChildActor(String actorName, ActorContext context){
		
		ActorRef child = context.actorOf(sExtension.props(actorName), actorName);
		
		return child;
	}
}
