package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TPolicyIndex;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PolicyIndexDao extends CrudRepository<TPolicyIndex, Long>, OrganizationAware {

	@Query("select a from TPolicyIndex a where a.policyId = :policyId")
	public TPolicyIndex findPolicyIndexByPolicyId(@Param("policyId") Long policyId);
}
