package insurance.claim.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import insurance.claim.dao.pojo.TClaim;

public interface ClaimDao   extends CrudRepository<TClaim, Long>{
	@Query("SELECT m FROM #{#entityName} m WHERE m.claimNumber=:claimNumber")
	public TClaim findByClaimNumber(@Param("claimNumber") String claimNumber);
	
	@Query("SELECT m from #{#entityName} m WHERE m.policyNumber=:policyNumber")
	public List<TClaim> findByPolicyNumber(@Param("policyNumber") String policyNumber);
}
