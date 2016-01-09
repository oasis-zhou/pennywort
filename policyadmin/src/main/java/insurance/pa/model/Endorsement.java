package insurance.pa.model;

import insurance.fd.model.BaseModel;
import insurance.pa.model.enums.EndorsementAplyType;
import insurance.pa.model.enums.EndorsementStatus;
import insurance.pa.model.enums.EndorsementType;
import insurance.price.model.Fee;
import insurance.price.model.ModelWithFee;

import java.util.Date;

public abstract class Endorsement extends BaseModel implements ModelWithFee{

	private Long endorsementId;
	private Long policyId;
	private String policyNumber;
	private EndorsementType endorsementType;
	private EndorsementStatus endorsementStatus;
	private Date effectiveDate;
	private Date applicationDate;
	private Date issueDate;
	private String endorsementNumber;
	private String wording;
	private EndorsementAplyType applicationType;
	private Integer sequence;
	private Fee fee;
	
	public Long getEndorsementId() {
		return endorsementId;
	}
	public void setEndorsementId(Long endorsementId) {
		this.endorsementId = endorsementId;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}	
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}	
	public EndorsementType getEndorsementType() {
		return endorsementType;
	}
	public void setEndorsementType(EndorsementType endorsementType) {
		this.endorsementType = endorsementType;
	}
	public EndorsementStatus getEndorsementStatus() {
		return endorsementStatus;
	}
	public void setEndorsementStatus(EndorsementStatus endorsementStatus) {
		this.endorsementStatus = endorsementStatus;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getEndorsementNumber() {
		return endorsementNumber;
	}
	public void setEndorsementNumber(String endorsementNumber) {
		this.endorsementNumber = endorsementNumber;
	}
	public String getWording() {
		return wording;
	}
	public void setWording(String wording) {
		this.wording = wording;
	}
	public EndorsementAplyType getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(EndorsementAplyType applicationType) {
		this.applicationType = applicationType;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Fee getFee() {
		if(fee == null){
			fee = new Fee(this.getUuid(),this.getClass().getSimpleName());
		}
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}


}
