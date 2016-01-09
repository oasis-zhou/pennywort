package insurance.claim.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class ClaimItem {
	/**
	 * Claim Item ID(PK)
	 */	
	private Long itemId;
	/**
	 * indemnityAmount=reserveAmount + paymentAmount - subrogationAmount
	 * 赔偿总额
	 */
	private BigDecimal indemnityAmount;
	/**
	 * payment amount of loss indemnity
	 * 赔款
	 */
	private BigDecimal paymentAmount;
	/**
	 * outstanding reserve amount
	 * 准备金
	 */
	private BigDecimal reserveAmount;
	/**
	 * subrogation amount
	 * 追偿款
	 */
	private BigDecimal subrogationAmount;
	/**
	 * Coverage UUID
	 */
	private String coverageId;
	/**
	 * Coverage Name
	 */
	private String coverageName;
	/**
	 * 险种代码
	 */
	@NotNull(message="险种代码为空")
	private String coverageCode;
	/**
	 * 理赔申请金额
	 */
	@Min(value=0,message="申赔金额小于0")
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