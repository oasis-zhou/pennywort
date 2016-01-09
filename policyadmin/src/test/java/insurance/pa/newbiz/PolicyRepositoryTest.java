package insurance.pa.newbiz;

import insurance.AbstractTest;
import insurance.pa.model.Policy;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PolicyRepositoryTest extends AbstractTest{

	@Autowired
	PolicyRepository policyService;


	@Test
	public void saveLoadQuotation(){
		Policy quotation = this.createPolicyFromFile();

		Policy quoIns = policyService.saveQuotation(quotation);

		Assert.assertNotNull(quoIns.getQuotationId());

		Long quotationId = quoIns.getQuotationId();

		Policy quo = policyService.loadQuotation(quotationId);

		Assert.assertEquals(quotationId, quo.getQuotationId());


	}

	@Test
	public void saveLoadPolicy(){
		Policy policy = this.createPolicyFromFile();

		Policy pins = policyService.savePolicy(policy);

		Assert.assertNotNull(pins.getPolicyId());

		Long policyId = pins.getPolicyId();

		Policy p = policyService.loadPolicy(policyId);

		Assert.assertEquals(policyId, p.getPolicyId());
	}

	@Test
	public void createQuoationIndex(){
		Policy quotation = this.createPolicyFromFile();
		policyService.saveQuotationIndex(quotation);
	}

	@Test
	public void createPolicyIndex(){
		Policy policy = this.createPolicyFromFile();
		policyService.savePolicyIndex(policy);
	}
}
