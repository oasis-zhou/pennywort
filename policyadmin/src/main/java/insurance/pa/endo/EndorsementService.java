package insurance.pa.endo;

import insurance.pa.model.Endorsement;

public interface EndorsementService {

	public void calculate(Endorsement endorsement);
	
	public void issue(Endorsement endorsement);
	
	public String generateWording(Endorsement endorsement);
	
	public void reject(Long endorsementId);
	
}
