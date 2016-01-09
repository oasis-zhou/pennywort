package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TQuotationInsuredIndex;

import org.springframework.data.repository.CrudRepository;

public interface QuotationInsuredIndexDao extends CrudRepository<TQuotationInsuredIndex, Long>, OrganizationAware{

}
