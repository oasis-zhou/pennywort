package insurance.claim.dao.pojo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import insurance.fd.model.BaseEntity;

public class TNoticeOfLoss extends BaseEntity{

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long onlId;
	@Column
	@NotNull
	private Date accidentTime;
	@Column
	@NotNull
	private Date claimTime;
	@Column
	private String accidentDescription;
	@Column
	private String policyNumber;
	@Column
	private String accidentCause;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String content;
	
	public Long getOnlId() {
		return onlId;
	}
	public void setOnlId(Long onlId) {
		this.onlId = onlId;
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
	public String getAccidentDescription() {
		return accidentDescription;
	}
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getAccidentCause() {
		return accidentCause;
	}
	public void setAccidentCause(String accidentCause) {
		this.accidentCause = accidentCause;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
