package insurance.claim.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class ClaimSubrogation {

	private Long subrogationId;
	private String status;
	private Date approveDate;
	private String claimNumber;
	private String coverageCode;
	private BigDecimal subrogationAmount;
	private ClaimParty payor;
	
	public Long getSubrogationId() {
		return subrogationId;
	}
	public void setSubrogationId(Long subrogationId) {
		this.subrogationId = subrogationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getCoverageCode() {
		return coverageCode;
	}
	public void setCoverageCode(String coverageCode) {
		this.coverageCode = coverageCode;
	}
	public BigDecimal getSubrogationAmount() {
		return subrogationAmount;
	}
	public void setSubrogationAmount(BigDecimal subrogationAmount) {
		this.subrogationAmount = subrogationAmount;
	}
	public ClaimParty getPayor() {
		return payor;
	}
	public void setPayor(ClaimParty payor) {
		this.payor = payor;
	}


}