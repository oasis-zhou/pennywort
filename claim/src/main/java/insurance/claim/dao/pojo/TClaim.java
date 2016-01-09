package insurance.claim.dao.pojo;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import insurance.fd.model.BaseEntity;

@Entity
@Table(name = "T_CLM_CLAIM", uniqueConstraints = { @UniqueConstraint(columnNames = { "claimNumber" }) })
public class TClaim extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long claimId;
	@Column
	@NotNull
	private Date accidentTime;
	@Column
	@NotNull
	private Date claimTime;
	@Column
	private String policyNumber;
	@Column
	private String accidentCause;
	@Column
	@NotNull
	private String status;
	@Column
	private String productId;
	@Column
	@NotNull
	private String channelId;
	@Column
	private String referenceNumber;
	@Column
	@NotNull
	private String claimNumber;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String content;
	
	public Long getClaimId() {
		return claimId;
	}
	public void setClaimId(Long claimId) {
		this.claimId = claimId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
