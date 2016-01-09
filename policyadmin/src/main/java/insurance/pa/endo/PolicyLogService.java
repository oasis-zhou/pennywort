package insurance.pa.endo;

import insurance.pa.model.Policy;


public interface PolicyLogService {

	public void logPolicy(Long endoId,Integer logType,Long policyId);
	
	public Policy loadLogPolicy(Long endoId,Integer logType);
	
	public void disablePolicyLog(Long endoId);
}
