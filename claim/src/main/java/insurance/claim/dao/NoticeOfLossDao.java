package insurance.claim.dao;

import org.springframework.data.repository.CrudRepository;

import insurance.claim.dao.pojo.TNoticeOfLoss;

public interface NoticeOfLossDao extends CrudRepository<TNoticeOfLoss, Long>{

}
