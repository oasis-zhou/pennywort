package insurance.pa.newbiz.dao.pojo;

import insurance.fd.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_POLICY_INDEX")
public class TPolicyIndex extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3845487402786350341L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private String productId;
	@Column
	private Date effDate;
	@Column
	private Date expDate;
	@Column
	private String quotationNumber;
	@Column
	private String policyNumber;
	@Column
	private Date proposalDate;
	@Column
	private Date quotationDate;
	@Column
	private Date issueDate;
	@Column
	private Integer contractStatus;
	@Column
	private String bizOrgan;
	@Column
	private String channelId;
	@Column
	private String phName;
	@Column
	private Integer phIdType;
	@Column
	private String phIdNumber;
	@Column
	private String phRegNumber;
	@Column
	private BigDecimal premium;
	@Column
	private String version;
	@Column
	private Long policyId;

	@Column
	private String field01;
	@Column
	private String field02;
	@Column
	private String field03;
	@Column
	private String field04;
	@Column
	private String field05;
	
	@OneToMany(mappedBy="policy", cascade= CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)     
	private Set<TInsuredIndex> insureds = new HashSet<TInsuredIndex>();
	
	@OneToMany(mappedBy="policy", cascade=CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)     	
	private Set<TCustomerIndex> customers = new HashSet<TCustomerIndex>();;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	public String getQuotationNumber() {
		return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Date getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}
	public Date getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Integer getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getBizOrgan() {
		return bizOrgan;
	}
	public void setBizOrgan(String bizOrgan) {
		this.bizOrgan = bizOrgan;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getPhName() {
		return phName;
	}
	public void setPhName(String phName) {
		this.phName = phName;
	}
	public Integer getPhIdType() {
		return phIdType;
	}
	public void setPhIdType(Integer phIdType) {
		this.phIdType = phIdType;
	}
	public String getPhIdNumber() {
		return phIdNumber;
	}
	public void setPhIdNumber(String phIdNumber) {
		this.phIdNumber = phIdNumber;
	}
	public String getPhRegNumber() {
		return phRegNumber;
	}
	public void setPhRegNumber(String phRegNumber) {
		this.phRegNumber = phRegNumber;
	}
	public BigDecimal getPremium() {
		return premium;
	}
	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getField01() {
		return field01;
	}
	public void setField01(String field01) {
		this.field01 = field01;
	}
	public String getField02() {
		return field02;
	}
	public void setField02(String field02) {
		this.field02 = field02;
	}
	public String getField03() {
		return field03;
	}
	public void setField03(String field03) {
		this.field03 = field03;
	}
	public String getField04() {
		return field04;
	}
	public void setField04(String field04) {
		this.field04 = field04;
	}
	public String getField05() {
		return field05;
	}
	public void setField05(String field05) {
		this.field05 = field05;
	}
	public Set<TInsuredIndex> getInsureds() {
		return insureds;
	}
	public void setInsureds(Set<TInsuredIndex> insureds) {
		this.insureds = insureds;
	}
	public Set<TCustomerIndex> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<TCustomerIndex> customers) {
		this.customers = customers;
	}
	
	
}
