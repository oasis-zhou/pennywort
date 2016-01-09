package insurance.pa.endo.impl;

import insurance.fd.utils.JsonHelper;
import insurance.pa.endo.EndorsementRepository;
import insurance.pa.endo.EndorsementService;
import insurance.pa.endo.PolicyLogService;
import insurance.pa.endo.dao.EndorsementDao;
import insurance.pa.endo.dao.pojo.TEndorsement;
import insurance.pa.model.Endorsement;
import insurance.pa.model.Policy;
import insurance.pa.model.enums.EndorsementStatus;
import insurance.pa.model.enums.LogType;
import insurance.pa.newbiz.PolicyRepository;
import insurance.pa.pub.Guid;
import insurance.price.PricingProcess;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndorsementServiceImpl implements EndorsementService {

	@Autowired
	private EndorsementDao endoDao;

	@Autowired
	private PolicyLogService logService;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private EndorsementRepository endoRepository;
	
	@Autowired
	private JsonHelper jsonHelper;

	@Autowired
	private Guid guid;

	@Resource(name = "EndoPremiumProcess")
	PricingProcess<Endorsement> process;

	
	@Override
	public void calculate(Endorsement endorsement) {
		process.launch(endorsement);
	}

	@Override
	public void issue(Endorsement endorsement) {

		String endorsementNumber = guid.generateEndorsementNumber();
		endorsement.setEndorsementNumber(endorsementNumber);

		endorsement.setEndorsementStatus(EndorsementStatus.ISSUE);

		endoRepository.save(endorsement);

		//TODO post endorsement premium to BCP
//		writeToBCP(endorsement);

	}

	@Override
	public String generateWording(Endorsement endorsement){

		return "";
	}

	@Override
	public void reject(Long endorsementId){

		TEndorsement p = endoDao.findOne(endorsementId);

		p.setStatus(EndorsementStatus.REJECT.getId());

		endoDao.save(p);

		//TODO recall policy info
		Policy policy = logService.loadLogPolicy(endorsementId, LogType.ISSUE_LOG.getId());

		policyRepository.savePolicy(policy);

		logService.disablePolicyLog(endorsementId);
	}


}
