package insurance.claim.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class ClaimSubrogation {
	
	/**
	 * Subrogation ID(PK)
	 */
	private Long subrogationId;
	/**
	 * Status(1:Open/9:Close)
	 */
	private String status;
	/**
	 * 收款日期
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
	 * 追偿款
	 */
	@NotNull(message="追偿金额为空")
	@Min(value=0,message="追偿金额小于0" )
	private BigDecimal subrogationAmount;
	/**
	 * 付款人信息
	 */
	@NotNull(message="付款人信息为空")
	@Valid
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