package insurance.claim.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


public class Claim {

	private Long claimId;
	private String claimNumber;
	private String productCode;
	private String status;
	private String policyNumber;
	private Date accidentTime;
	private Date claimTime;
	private String accidentCause;
	private String accidentDescription;
	private Map<String, Object> businessContent;
	private String referenceNumber;
	private String isSubrogation;
	private ClaimParty claimant;
	private List<ClaimItem> claimItems;
	private List<ClaimSettlement> claimSettlements;
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