package insurance.pa.newbiz;

import insurance.pa.model.Policy;

public interface PolicyService {

	public void calculate(Policy policy);
	
	public void issue(Policy policy);

}
