package insurance.claim.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


public class Claim {

	/**
	 * Claim ID(PK)
	 */
	private Long claimId;
	/**
	 * 理赔号
	 */
	private String claimNumber;
	/**
	 *产品代码
	 */
	private String productCode;
	/**
	 * 状态(1:Open/2:Reopen/3:Reject/9:Close)
	 */
	private String status;
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
	 * 业务数据
	 */
	private Map<String, Object> businessContent;
	/**
	 * 渠道业务号码
	 */
	private String referenceNumber;
	/**
	 * 是否有追偿
	 */
	private String isSubrogation;
	/**
	 * 索赔人信息
	 */
	@NotNull(message="索赔人信息为空")
	@Valid
	private ClaimParty claimant;
	/**
	 * 理赔项目信息
	 */
	@NotNull(message="理赔项目信息为空")
	@Valid
	private List<ClaimItem> claimItems;
	/**
	 * 赔款信息
	 */
	private List<ClaimSettlement> claimSettlements;
	/**
	 * 追偿信息
	 */
	private List<ClaimSubrogation> claimSubrogations;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Map<String, Object> getBusinessContent() {
		return businessContent;
	}

	public void setBusinessContent(Map<String, Object> businessContent) {
		this.businessContent = businessContent;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getIsSubrogation() {
		return isSubrogation;
	}

	public void setIsSubrogation(String isSubrogation) {
		this.isSubrogation = isSubrogation;
	}

	public ClaimParty getClaimant() {
		return claimant;
	}

	public void setClaimant(ClaimParty claimant) {
		this.claimant = claimant;
	}

	public List<ClaimItem> getClaimItems() {
		if(this.claimItems==null){
			this.claimItems=new ArrayList<ClaimItem>();
		}
		return claimItems;
	}

	public void setClaimItems(List<ClaimItem> claimItems) {
		this.claimItems = claimItems;
	}
	public List<ClaimSettlement> getClaimSettlements() {
		if(this.claimSettlements==null){
			this.claimSettlements=new ArrayList<ClaimSettlement>();
		}
		return claimSettlements;
	}

	public void setClaimSettlements(List<ClaimSettlement> claimSettlements) {
		this.claimSettlements = claimSettlements;
	}

	public List<ClaimSubrogation> getClaimSubrogations() {
		if(this.claimSubrogations==null){
			this.claimSubrogations=new ArrayList<ClaimSubrogation>();
		}
		return claimSubrogations;
	}

	public void setClaimSubrogations(
			List<ClaimSubrogation> claimSubrogations) {
		this.claimSubrogations = claimSubrogations;
	}
	
}