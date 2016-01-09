package insurance;


import insurance.fd.utils.JsonHelper;
import insurance.pa.model.Policy;

import java.io.InputStream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-beans-test.xml"})
@ActiveProfiles(profiles="hsql" )
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
public abstract class AbstractTest {
	
	@Autowired
	private JsonHelper jsonHelper;

	public Policy createPolicyFromFile(){

		String path = "/testdata/policy.txt";

		Policy policy = null;

		try{
			InputStream input = this.getClass().getResourceAsStream(path);  

			policy = jsonHelper.fromJSON(input, Policy.class);

			//		System.out.print("*****************Prepare Policy End********************\n");

		}catch(Exception e){
			e.printStackTrace();

		}
		return policy;
	}
	
	public String createJsonPolicy(){
		String path = "/testdata/policy.txt";

		String jsonPolicy = null;

		try{
			InputStream input = this.getClass().getResourceAsStream(path);  

			Policy policy = jsonHelper.fromJSON(input, Policy.class);
			
			jsonPolicy = jsonHelper.toJSON(policy);

			//		System.out.print("*****************Prepare Policy End********************\n");

		}catch(Exception e){
			e.printStackTrace();

		}
		return jsonPolicy;
	}
}
