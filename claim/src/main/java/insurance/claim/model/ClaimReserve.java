package insurance.claim.model;

import java.math.BigDecimal;
import java.util.Date;

public class ClaimReserve{
	
	/**
	 * 赔案号
	 */
	private String claimNumber;
	/**
	 * Claim Item ID
	 */
	private Long itemId;
	/**
	 * 险种名称
	 */
	private String coverageName;
	/**
	 * 险种代码
	 */
	private String coverageCode;
	/**
	 * 变更后准备金
	 */
	private BigDecimal reserveAmount;
	/**
	 * 准备金变更金额
	 */
	private BigDecimal changeAmount;
	/**
	 * 准备金变更类型{@link ReserveChangeType}
	 */
	private String changeType;
	/**
	 * 变更时间
	 */
	private Date changeDate;
	
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
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
	public BigDecimal getReserveAmount() {
		return reserveAmount;
	}
	public void setReserveAmount(BigDecimal reserveAmount) {
		this.reserveAmount = reserveAmount;
	}
	public BigDecimal getChangeAmount() {
		return changeAmount;
	}
	public void setChangeAmount(BigDecimal changeAmount) {
		this.changeAmount = changeAmount;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	
}
