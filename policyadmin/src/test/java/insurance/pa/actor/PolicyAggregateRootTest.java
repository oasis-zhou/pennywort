package insurance.pa.actor;

import insurance.AbstractTest;
import insurance.fd.conf.SpringExtension;
import insurance.fd.context.AppContext;
import insurance.fd.utils.JsonHelper;
import insurance.pa.model.Policy;
import insurance.pa.msg.IssuePolicyMsg;
import insurance.pa.msg.NewbizPricingMsg;
import insurance.pa.msg.enums.PricingType;
import insurance.pa.pub.Guid;
import insurance.price.model.Fee;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;

public class PolicyAggregateRootTest extends AbstractTest {

	@Autowired
	private SpringExtension sExtension;

	@Autowired
	private JsonHelper jsonHelper;
	
	private ActorSystem actorSystem;

	@Before
	public void setUp() {
		actorSystem = AppContext.getBean(ActorSystem.class);
	}

//	@Test
	public void calculatePremium(){
		new JavaTestKit(actorSystem) {{

			String path = "/testdata/policy.txt";

			Policy policy = null;

			try{
				InputStream input = this.getClass().getResourceAsStream(path);  

				policy = jsonHelper.fromJSON(input, Policy.class);

			}catch(Exception e){
				e.printStackTrace();

			}

			NewbizPricingMsg msg = new NewbizPricingMsg(Guid.generate(),policy);

			ActorRef policyActor = actorSystem.actorOf(sExtension.props("PolicyAggregateRoot"), "PolicyAggregateRoot");
			policyActor.tell(msg, getRef());

			expectNoMsg(duration("3 second"));

			Fee fee = policy.getFee();

			String rMsg = jsonHelper.toJSON(fee);

			System.out.print("######fee=" + rMsg);

			//			expectMsgEquals(duration("1 second"), "OK");

		}};
	}

	@Test
	public void issuePolicy(){
		new JavaTestKit(actorSystem) {{

			String path = "/testdata/policy.txt";

			Policy policy = null;

			try{
				InputStream input = this.getClass().getResourceAsStream(path);  

				policy = jsonHelper.fromJSON(input, Policy.class);

			}catch(Exception e){
				e.printStackTrace();

			}

			NewbizPricingMsg cmsg = new NewbizPricingMsg(policy.getUuid(),policy);

			ActorRef policyActor = actorSystem.actorOf(sExtension.props("PolicyAggregateRoot"), "PolicyAggregateRoot");
			policyActor.tell(cmsg, getRef());
			
			expectNoMsg(duration("1 second"));

			Fee fee = policy.getFee();

			String rMsg = jsonHelper.toJSON(fee);
			
			System.out.print("######fee=" + rMsg + "\n");

			IssuePolicyMsg imsg = new IssuePolicyMsg(policy.getUuid(),policy);

			policyActor.tell(imsg, getRef());

			expectNoMsg(duration("1 second"));
			
			System.out.print("######policyid=" + policy.getPolicyId() + "\n");

			//			expectMsgEquals(duration("1 second"), "OK");

		}};
	}

	@After
	public void tearDown() {
		JavaTestKit.shutdownActorSystem(actorSystem);
		actorSystem = null;
	}
}
