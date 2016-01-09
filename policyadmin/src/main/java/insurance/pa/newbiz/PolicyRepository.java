package insurance.pa.newbiz;

import insurance.pa.model.Policy;

public interface PolicyRepository {

	public <T extends Policy> T saveQuotation(T policy);
	
	public Policy loadQuotation(Long quotationId);
	
	public <T extends Policy> T savePolicy(T policy);
	
	public Policy loadPolicy(Long policyId);
	
	public <T extends Policy> void saveQuotationIndex(T policy);
	
	public <T extends Policy> void savePolicyIndex(T policy);
	
	
}
