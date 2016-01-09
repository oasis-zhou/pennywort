package insurance.pa.endo.impl;

import insurance.fd.utils.JsonHelper;
import insurance.pa.endo.PolicyLogService;
import insurance.pa.endo.dao.PolicyLogDao;
import insurance.pa.endo.dao.pojo.TPolicyLog;
import insurance.pa.model.Policy;
import insurance.pa.model.enums.LogType;
import insurance.pa.newbiz.dao.PolicyDao;
import insurance.pa.newbiz.dao.pojo.TPolicy;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyLogServiceImpl implements PolicyLogService {

	@Autowired
	private PolicyDao policyDao;

	@Autowired
	private PolicyLogDao logDao;
	
	@Autowired
	private JsonHelper jsonHelper;

	@Override
	public void logPolicy(Long endoId, Integer logType, Long policyId) {
		TPolicy policy = policyDao.findOne(policyId);

		TPolicyLog policyLog = new TPolicyLog();
		BeanUtils.copyProperties(policy, policyLog);
		policyLog.setEndoId(endoId);
		policyLog.setPolicyId(policyId);
		policyLog.setLogType(logType);

		logDao.save(policyLog);
	}

	@Override
	public Policy loadLogPolicy(Long endoId, Integer logType) {
		TPolicyLog policyLog = logDao.findByGroupId(endoId, logType);

		Policy policy = jsonHelper.fromJSON(policyLog.getContent(), Policy.class);

		return policy;
	}

	@Override
	public void disablePolicyLog(Long endoId) {

		TPolicyLog policyLog = logDao.findByGroupId(endoId, LogType.ISSUE_LOG.getId());

		policyLog.setLogType(LogType.INVALID_ISSUE_LOG.getId());

		logDao.save(policyLog);

	}

}
