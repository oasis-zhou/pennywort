package insurance.claim.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class ClaimSettlement{

	/**
	 * Settlement ID(PK)
	 */
	private Long settlementId;
	/**
	 * Status(1:Open/9:Close)
	 */
	private String status;
	/**
	 * 付款日期
	 */
	private Date approveDate;
	/**
	 * 理赔号
	 */
	@NotNull(message="赔案号为空")	
	private String claimNumber;
	/**
	 * 险种代码
	 */
	@NotNull(message="险种代码为空")
	private String coverageCode;
	/**
	 * 赔款
	 */
	@NotNull(message="赔款金额为空")
	@Min(value=0,message="赔款金额小于0")
	private BigDecimal settlementAmount;
	/**
	 * 收款人信息
	 */
	@NotNull(message="收款人信息为空")
	@Valid
	private ClaimParty payee;
	
	public Long getSettlementId() {
		return settlementId;
	}
	public void setSettlementId(Long settlementId) {
		this.settlementId = settlementId;
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
	public BigDecimal getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public ClaimParty getPayee() {
		return payee;
	}
	public void setPayee(ClaimParty payee) {
		this.payee = payee;
	}

	
}