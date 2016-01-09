package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TInsuredIndex;

import org.springframework.data.repository.CrudRepository;

public interface InsuredIndexDao extends CrudRepository<TInsuredIndex, Long>, OrganizationAware {

}
