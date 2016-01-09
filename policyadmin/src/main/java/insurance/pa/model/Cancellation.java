package insurance.pa.model;

import insurance.pa.model.enums.CancellationType;
import insurance.pa.model.enums.EndorsementType;

public class Cancellation extends Endorsement {

	private CancellationType cancellationType;
	private Integer reason;
	
	public Cancellation() {
		this.setEndorsementType(EndorsementType.CANCELLATION);
	}

	public CancellationType getCancellationType() {
		return cancellationType;
	}

	public void setCancellationType(CancellationType cancellationType) {
		this.cancellationType = cancellationType;
	}

	public Integer getReason() {
		return reason;
	}

	public void setReason(Integer reason) {
		this.reason = reason;
	}
	
}
