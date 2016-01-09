package insurance.pa.newbiz.impl;

import insurance.pa.model.Customer;
import insurance.pa.model.Insured;
import insurance.pa.model.OrganizationCustomer;
import insurance.pa.model.PersonCustomer;
import insurance.pa.model.Policy;
import insurance.pa.model.StandardPolicy;
import insurance.pa.newbiz.PolicyIndexFactory;
import insurance.pa.newbiz.dao.pojo.TCustomerIndex;
import insurance.pa.newbiz.dao.pojo.TInsuredIndex;
import insurance.pa.newbiz.dao.pojo.TPolicyIndex;
import insurance.pa.newbiz.dao.pojo.TQuotationIndex;
import insurance.pa.newbiz.dao.pojo.TQuotationInsuredIndex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PolicyIndexFactoryImpl implements PolicyIndexFactory {

	@Override
	public void buildQuotationIndex(TQuotationIndex po,Policy policy) {

		po.setProductId(policy.getProductId());
		po.setProposalDate(policy.getProposalDate());
		po.setEffDate(policy.getEffectiveDate());
		po.setExpDate(policy.getExpiredDate());
		po.setBizOrgan(policy.getBusinessOrgan());
		po.setVersion(policy.getVersion());

		po.setQuotationId(policy.getQuotationId());

		if(policy instanceof StandardPolicy){
			StandardPolicy sp = (StandardPolicy)policy;
			po.setChannelId(sp.getChannelId());
			po.setQuotationDate(sp.getQuotationDate());
			po.setQuotationNumber(sp.getQuotationNumber());
			po.setQuotationStatus(sp.getQuotationStatus().getId());
			
			List<Customer> customers = sp.getCustomers();
			for(Customer customer : customers){
				if(customer instanceof PersonCustomer){
					if(((PersonCustomer)customer).isPolicyHolder()){
						po.setPhName(((PersonCustomer)customer).getName().getFullName());
						po.setPhIdType(((PersonCustomer)customer).getIdType());
						po.setPhIdNumber(((PersonCustomer)customer).getIdNumber());					
					}				
				}else if(customer instanceof OrganizationCustomer){
					if(((OrganizationCustomer)customer).isPolicyHolder()){
						po.setPhName(((OrganizationCustomer)customer).getName());
						po.setPhRegNumber(((OrganizationCustomer)customer).getRegistrationNo());
					}
				}			
			}
			
			Set<TQuotationInsuredIndex> insuredIndexs = buildQuotationInsuredIndex(po,sp);
			po.getInsureds().clear();
			po.getInsureds().addAll((insuredIndexs));
		}

	}
	
	@Override
	public Set<TQuotationInsuredIndex> buildQuotationInsuredIndex(TQuotationIndex po,Policy policy) {		
		Set<TQuotationInsuredIndex> insuredIndexs = new HashSet<TQuotationInsuredIndex>();
		List<Insured> insureds = policy.getInsureds();
		for(Insured insured : insureds){
			TQuotationInsuredIndex insuredPo = new TQuotationInsuredIndex();
			insuredPo.setQuotaion(po);
			insuredPo.setName(insured.getInsuredName());
			insuredIndexs.add(insuredPo);
		}
		return insuredIndexs;
	}

	@Override
	public void buildPolicyIndex(TPolicyIndex po,Policy policy) {

		po.setProductId(policy.getProductId());
		po.setPolicyNumber(policy.getPolicyNumber());
		po.setProposalDate(policy.getProposalDate());
		po.setEffDate(policy.getEffectiveDate());
		po.setExpDate(policy.getExpiredDate());
		po.setBizOrgan(policy.getBusinessOrgan());
		po.setVersion(policy.getVersion());
		po.setContractStatus(policy.getContractStatus().getId());

		po.setPolicyId(policy.getPolicyId());
		
		if(policy instanceof StandardPolicy){
			StandardPolicy sp = (StandardPolicy)policy;
			po.setChannelId(sp.getChannelId());
			po.setQuotationDate(sp.getQuotationDate());
			po.setQuotationNumber(sp.getQuotationNumber());	
			
			List<Customer> customers = sp.getCustomers();
			for(Customer customer : customers){
				if(customer instanceof PersonCustomer){
					if(((PersonCustomer)customer).isPolicyHolder()){
						po.setPhName(((PersonCustomer)customer).getName().getFullName());
						po.setPhIdType(((PersonCustomer)customer).getIdType());
						po.setPhIdNumber(((PersonCustomer)customer).getIdNumber());
					}
					
				}else if(customer instanceof OrganizationCustomer){
					if(((OrganizationCustomer)customer).isPolicyHolder()){
						po.setPhName(((OrganizationCustomer)customer).getName());
						po.setPhRegNumber(((OrganizationCustomer)customer).getRegistrationNo());
					}
					
				}
			}
			
			Set<TCustomerIndex> customerIndexs = buildCustomerIndex(po,sp);
			po.getCustomers().clear();
			po.getCustomers().addAll((customerIndexs));
			
			Set<TInsuredIndex> insuredIndexs = buildInsuredIndex(po,sp);
			po.getInsureds().clear();
			po.getInsureds().addAll((insuredIndexs));
		}

	}

	@Override
	public Set<TCustomerIndex> buildCustomerIndex(TPolicyIndex po,Policy policy) {
		Set<TCustomerIndex> customerIndexs = new HashSet<TCustomerIndex>();
		List<Customer> customers = policy.getCustomers();
		for(Customer customer : customers){
			if(customer instanceof PersonCustomer){				
				TCustomerIndex customerPo = new TCustomerIndex();
				customerPo.setPolicy(po);
				customerPo.setName(((PersonCustomer)customer).getName().getFullName());
				customerPo.setIdType(((PersonCustomer)customer).getIdType());
				customerPo.setIdNumber(((PersonCustomer)customer).getIdNumber());
//				customerPo.setPartyId(customer.getId());
//				customerPo.setPartyCategory(((PersonCustomer)customer).getCategory().getId());
//				customerPo.setPartyRole(((PersonCustomer)customer).getPartyRole().getId());
				customerIndexs.add(customerPo);		
				
			}else if(customer instanceof OrganizationCustomer){			
				TCustomerIndex customerPo = new TCustomerIndex();
				customerPo.setPolicy(po);
				customerPo.setName(((OrganizationCustomer)customer).getName());
				customerPo.setRegNumber(((OrganizationCustomer)customer).getRegistrationNo());
//				customerPo.setPartyId(customer.getId());
//				customerPo.setPartyCategory(((OrganizationCustomer)customer).getCategory().getId());
//				customerPo.setPartyRole(((OrganizationCustomer)customer).getPartyRole().getId());
				customerIndexs.add(customerPo);
			}
		}
		return customerIndexs;
	}

	@Override
	public Set<TInsuredIndex> buildInsuredIndex(TPolicyIndex po,Policy policy) {
		Set<TInsuredIndex> insuredIndexs = new HashSet<TInsuredIndex>();
		List<Insured> insureds = policy.getInsureds();
		for(Insured insured : insureds){
			TInsuredIndex insuredPo = new TInsuredIndex();
			insuredPo.setPolicy(po);
			insuredPo.setName(insured.getInsuredName());
			insuredIndexs.add(insuredPo);
		}
		return insuredIndexs;
	}

}
