package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TCustomerIndex;

import org.springframework.data.repository.CrudRepository;

public interface CustomerIndexDao extends CrudRepository<TCustomerIndex, Long>, OrganizationAware{

}
