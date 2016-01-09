package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TQuotation;

import org.springframework.data.repository.CrudRepository;

public interface QuotationDao extends CrudRepository<TQuotation, Long>, OrganizationAware{
}
