package insurance.claim.dao;

import org.springframework.data.repository.CrudRepository;

import insurance.claim.dao.pojo.TClaimReopen;

public interface ClaimReopenDao  extends CrudRepository<TClaimReopen, Long>{

}
