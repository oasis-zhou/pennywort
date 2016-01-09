package insurance.claim.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class NoticeOfLoss {

	private Long nolId;
	private String policyNumber;
	private Date accidentTime;
	private Date claimTime;
	private String accidentCause;
	private String accidentDescription;
	private ClaimParty claimant;
	
	public Long getNolId() {
		return nolId;
	}
	public void setNolId(Long nolId) {
		this.nolId = nolId;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Date getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
	}
	public Date getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}
	public String getAccidentCause() {
		return accidentCause;
	}
	public void setAccidentCause(String accidentCause) {
		this.accidentCause = accidentCause;
	}
	public String getAccidentDescription() {
		return accidentDescription;
	}
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	public ClaimParty getClaimant() {
		return claimant;
	}
	public void setClaimant(ClaimParty claimant) {
		this.claimant = claimant;
	}
	
}
