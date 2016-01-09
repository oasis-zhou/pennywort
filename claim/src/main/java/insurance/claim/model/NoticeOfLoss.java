package insurance.claim.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class NoticeOfLoss {

	/**
	 * Notice of loss ID(PK)
	 */
	private Long nolId;
	/**
	 * 保单号
	 */
	@NotNull(message="保单号为空")
	private String policyNumber;
	/**
	 * 出险时间
	 */
	@NotNull(message="出险时间为空")
	@Past(message="出险时间不能晚于当前时间")
	private Date accidentTime;
	/**
	 * 理赔申请时间
	 */
	@NotNull(message="申赔时间为空")
	private Date claimTime;
	
//	@NotNull(message="出险原因为空")
	private String accidentCause;
	/**
	 * 事故描述
	 */
	private String accidentDescription;
	/**
	 * 索赔人信息
	 */
	@NotNull(message="索赔人信息为空")
	@Valid
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
