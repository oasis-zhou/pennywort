package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TPolicy;

import org.springframework.data.repository.CrudRepository;

public interface PolicyDao extends CrudRepository<TPolicy, Long>, OrganizationAware{

}
