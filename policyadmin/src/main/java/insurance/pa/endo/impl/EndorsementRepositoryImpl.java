package insurance.pa.endo.impl;

import insurance.fd.utils.JsonHelper;
import insurance.pa.endo.EndorsementRepository;
import insurance.pa.endo.PolicyLogService;
import insurance.pa.endo.dao.EndorsementDao;
import insurance.pa.endo.dao.pojo.TEndorsement;
import insurance.pa.model.Endorsement;
import insurance.pa.model.enums.EndorsementStatus;
import insurance.pa.model.enums.LogType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class EndorsementRepositoryImpl implements EndorsementRepository {

	@Autowired
	private EndorsementDao endoDao;
	
	@Autowired
	private PolicyLogService logService;
	
	@Autowired
	private JsonHelper jsonHelper;
	
	@Override
	public Long create(Endorsement endorsement){

		Assert.notNull(endorsement.getPolicyId());
		Assert.notNull(endorsement.getEndorsementType());

		endorsement.setEndorsementStatus(EndorsementStatus.QUOTATION);
		save(endorsement);

		Long endoId = endorsement.getEndorsementId();

		//backup policy to log table
		logService.logPolicy(endorsement.getEndorsementId(), LogType.ISSUE_LOG.getId(), endorsement.getPolicyId());

		return endoId;
	}

	@Override
	public void save(Endorsement endorsement) {

		TEndorsement po = new TEndorsement();	
		BeanUtils.copyProperties(endorsement, po);
		po.setType(endorsement.getEndorsementType().getId());
		if(endorsement.getEndorsementStatus() != null)
			po.setStatus(endorsement.getEndorsementStatus().getId());

		if(endorsement.getApplicationType() != null)
			po.setApplyType(endorsement.getApplicationType().getId());

		if(endorsement.getSequence() == null){

			Integer maxSequence = endoDao.findMaxSequence(endorsement.getPolicyId());
			Integer sequence = new Integer(1);

			if(maxSequence != null){				
				sequence = maxSequence + 1;
			}
			endorsement.setSequence(sequence);
			po.setSequence(sequence);

		}

		String content = jsonHelper.toJSON(endorsement);
		
		po.setContent(content);

		TEndorsement p = endoDao.save(po);

		endorsement.setEndorsementId(p.getId());
	}

	@Override
	public Endorsement load(Long endorsementId) {
		TEndorsement po = endoDao.findOne(endorsementId);
	
		Endorsement endorsement = jsonHelper.fromJSON(po.getContent(), Endorsement.class);

		endorsement.setEndorsementId(po.getId());

		return endorsement;
	}

}
