package insurance.pa.newbiz;

import insurance.pa.model.Policy;
import insurance.pa.newbiz.dao.pojo.TCustomerIndex;
import insurance.pa.newbiz.dao.pojo.TInsuredIndex;
import insurance.pa.newbiz.dao.pojo.TPolicyIndex;
import insurance.pa.newbiz.dao.pojo.TQuotationIndex;
import insurance.pa.newbiz.dao.pojo.TQuotationInsuredIndex;

import java.util.Set;

public interface PolicyIndexFactory {

	public void buildQuotationIndex(TQuotationIndex po,Policy policy);
	
	public Set<TQuotationInsuredIndex> buildQuotationInsuredIndex(TQuotationIndex po,Policy policy);
	
	public void buildPolicyIndex(TPolicyIndex po,Policy policy);
	
	public Set<TCustomerIndex> buildCustomerIndex(TPolicyIndex po,Policy policy);
	
	public Set<TInsuredIndex> buildInsuredIndex(TPolicyIndex po,Policy policy);
}
