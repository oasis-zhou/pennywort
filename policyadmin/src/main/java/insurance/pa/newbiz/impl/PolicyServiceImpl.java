package insurance.pa.newbiz.impl;

import insurance.fd.utils.JsonHelper;
import insurance.pa.model.Policy;
import insurance.pa.model.enums.ContractStatus;
import insurance.pa.model.enums.QuotationStatus;
import insurance.pa.newbiz.PolicyRepository;
import insurance.pa.newbiz.PolicyService;
import insurance.pa.pub.Guid;
import insurance.price.PricingProcess;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Resource(name = "NewbizPremiumProcess")
	private PricingProcess<Policy> process;
	
	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private Guid guid;
	
	@Override
	public void calculate(Policy policy) {		
		process.launch(policy);
	}

	@Override
	public void issue(Policy policy) {
		
		policy.setQuotationStatus(QuotationStatus.ISSUED);
		policy.setContractStatus(ContractStatus.EFFECTIVE);
		policy.setIssueDate(new Date());
		
		policy.setPolicyNumber(guid.generatePolicyNumber());
		
		policyRepository.savePolicy(policy);
	
	}

}
