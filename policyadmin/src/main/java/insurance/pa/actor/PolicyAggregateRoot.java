package insurance.pa.actor;

import insurance.fd.actor.ActorFactory;
import insurance.fd.actor.AggregateRoot;
import insurance.fd.utils.JsonHelper;
import insurance.pa.model.Policy;
import insurance.pa.msg.IssuePolicyMsg;
import insurance.pa.msg.NewbizPricingMsg;
import insurance.pa.newbiz.PolicyService;
import insurance.price.PricingProcess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.ActorContext;
import akka.actor.ActorRef;


@Named("PolicyAggregateRoot")
@Component
@Scope(value = "prototype")
public class PolicyAggregateRoot extends AggregateRoot<Policy> {

	private static Logger logger = LoggerFactory.getLogger(PolicyAggregateRoot.class);

	@Resource(name = "NewbizPremiumProcess")
	private PricingProcess<Policy> process;

	@Autowired
	private PolicyService pService;

	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private ActorFactory aFactory;


	private String aggregateId;
	private Policy policy;

	@Override
	public void handle(Object msg, ActorContext context) {

		logger.debug("Policy aggregate handle message \n");
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

	protected void apply(IssuePolicyMsg msg){
		Policy policy = (Policy)msg.getMessageBody();

		pService.issue(policy);

		logger.debug("Issue policy uuid =" + policy.getUuid() + " \n");
		logger.debug("Issue policy number =" + policy.getPolicyNumber() + " \n");
		
		ActorRef indexActor = aFactory.createChildActor("PolicyIndexActor", this.getContext());
		indexActor.tell(msg, self());
		
		

	}

	protected void apply(NewbizPricingMsg msg){

		Policy policy = (Policy)msg.getMessageBody();

		process.launch(policy);

		logger.debug("Calculate policy premium successful \n");
		
		ActorRef indexActor = aFactory.createChildActor("QuotationIndexActor", this.getContext());
		indexActor.tell(msg, self());


	}

	public String getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

}
