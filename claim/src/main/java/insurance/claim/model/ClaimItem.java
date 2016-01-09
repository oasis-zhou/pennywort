package insurance.claim.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class ClaimItem {
	private Long itemId;
	private BigDecimal indemnityAmount;
	private BigDecimal paymentAmount;
	private BigDecimal reserveAmount;
	private BigDecimal subrogationAmount;
	private String coverageId;
	private String coverageName;
	private String coverageCode;
	private BigDecimal claimAmount;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getIndemnityAmount() {
		return indemnityAmount;
	}
	public void setIndemnityAmount(BigDecimal indemnityAmount) {
		this.indemnityAmount = indemnityAmount;
	}
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public BigDecimal getReserveAmount() {
		return reserveAmount;
	}
	public void setReserveAmount(BigDecimal reserveAmount) {
		this.reserveAmount = reserveAmount;
	}
	public BigDecimal getSubrogationAmount() {
		return subrogationAmount;
	}
	public void setSubrogationAmount(BigDecimal subrogationAmount) {
		this.subrogationAmount = subrogationAmount;
	}
	public String getCoverageId() {
		return coverageId;
	}
	public void setCoverageId(String coverageId) {
		this.coverageId = coverageId;
	}
	public String getCoverageName() {
		return coverageName;
	}
	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}
	public String getCoverageCode() {
		return coverageCode;
	}
	public void setCoverageCode(String coverageCode) {
		this.coverageCode = coverageCode;
	}
	public BigDecimal getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}

}