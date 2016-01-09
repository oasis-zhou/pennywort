package insurance.pa.actor;

import insurance.fd.actor.AggregateRoot;
import insurance.fd.utils.JsonHelper;
import insurance.pa.endo.EndorsementRepository;
import insurance.pa.endo.EndorsementService;
import insurance.pa.model.Endorsement;
import insurance.pa.model.Policy;
import insurance.pa.msg.EndoPricingMsg;
import insurance.pa.msg.IssueEndorsementMsg;
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

@Named("EndoAggregateRoot")
@Component
@Scope(value = "prototype")
public class EndoAggregateRoot extends AggregateRoot<Endorsement> {

	private static Logger logger = LoggerFactory.getLogger(PolicyAggregateRoot.class);

	@Resource(name = "NewbizPremiumProcess")
	private PricingProcess<Policy> process;

	@Resource(name = "EndoPremiumProcess")
	PricingProcess endoProcess;

	@Autowired
	private PolicyService pService;

	@Autowired
	EndorsementService endoService;

	@Autowired
	private EndorsementRepository endoRepository;

	@Autowired
	private JsonHelper jsonHelper;


	private String aggregateId;

	private Endorsement endorsement;

	@Override
	public void handle(Object msg, ActorContext context) {

		logger.debug("Endorsement aggregate handle message \n");
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

	protected void apply(IssueEndorsementMsg msg){
		Endorsement endorsement = (Endorsement)msg.getMessageBody();

		endoService.issue(endorsement);

		logger.debug("Issue endorsement number =" + endorsement.getEndorsementNumber() + " \n");

	}

	protected void apply(EndoPricingMsg msg){

		Endorsement endorsement = (Endorsement)msg.getMessageBody();

		endoProcess.launch(endorsement);

		logger.debug("Calculate policy premium successful \n");


	}

	public String getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public Endorsement getEndorsement() {
		return endorsement;
	}

	public void setEndorsement(Endorsement endorsement) {
		this.endorsement = endorsement;
	}


}
