package insurance.pa.endo.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.endo.dao.pojo.TEndorsement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EndorsementDao  extends CrudRepository<TEndorsement, Long>, OrganizationAware{

	@Query("SELECT m FROM #{#entityName} m WHERE m.policyId =:policyId order by m.sequence desc")
	public TEndorsement findLastEndorsement(@Param("policyId") Long policyId);
	
	@Query("SELECT MAX(m.sequence) FROM #{#entityName} m WHERE m.policyId =:policyId")
	public Integer findMaxSequence(@Param("policyId") Long policyId);
	
	@Query("SELECT m FROM #{#entityName} m WHERE m.policyId =:policyId and (m.status = 10 or m.status = 20)")
	public TEndorsement findPendingEndorsement(@Param("policyId") Long policyId);
}
