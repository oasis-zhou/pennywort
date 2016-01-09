package insurance.pa.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import insurance.fd.anno.FieldSpec;
import insurance.fd.model.BaseModel;
import insurance.pa.model.enums.ContractStatus;
import insurance.pa.model.enums.QuotationStatus;
import insurance.pa.model.other.GRPolicy;
import insurance.price.model.Fee;
import insurance.price.model.ModelWithFee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "typeName")
@JsonSubTypes({@JsonSubTypes.Type(value=GRPolicy.class,name = "GRPolicy")})
public abstract class Policy extends BaseModel implements ModelWithFee{
	private Long quotationId;
	private Long policyId;
	@FieldSpec(code = "policy_productId", name = "policy product id")
	private String productId;
	@FieldSpec(code = "policy_channelId", name = "policy channel id")
	private String channelId;
	private String salesAgreementId;
	private String policyNumber;
	@FieldSpec(code = "policy_effectiveDate", name = "policy effective date")
	private Date effectiveDate;
	@FieldSpec(code = "policy_expiredDate", name = "policy expired date")
	private Date expiredDate;
	private Date proposalDate;
	private ContractStatus contractStatus;
	private QuotationStatus quotationStatus;
	private String businessOrgan;
	private Integer source;
	private Date issueDate;
	private String version;
	private BigDecimal AOALimitAmount;
	private BigDecimal AOPLimitAmount;
	private Fee fee;
	private List<Customer> customers;
	

	public abstract List<Insured> getInsureds();
	public abstract List<Coverage> getCoverages();
	
	
	public Long getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(Long quotationId) {
		this.quotationId = quotationId;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
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
	public String getSalesAgreementId() {
		return salesAgreementId;
	}
	public void setSalesAgreementId(String salesAgreementId) {
		this.salesAgreementId = salesAgreementId;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public Date getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}
	public ContractStatus getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
	}
	public QuotationStatus getQuotationStatus() {
		return quotationStatus;
	}
	public void setQuotationStatus(QuotationStatus quotationStatus) {
		this.quotationStatus = quotationStatus;
	}
	public String getBusinessOrgan() {
		return businessOrgan;
	}
	public void setBusinessOrgan(String businessOrgan) {
		this.businessOrgan = businessOrgan;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public BigDecimal getAOALimitAmount() {
		return AOALimitAmount;
	}
	public void setAOALimitAmount(BigDecimal aOALimitAmount) {
		AOALimitAmount = aOALimitAmount;
	}
	public BigDecimal getAOPLimitAmount() {
		return AOPLimitAmount;
	}
	public void setAOPLimitAmount(BigDecimal aOPLimitAmount) {
		AOPLimitAmount = aOPLimitAmount;
	}
	public Fee getFee() {
		if(fee == null){
			fee = new Fee(this.getUuid(),this.getClass().getSimpleName());
		}
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	public List<Customer> getCustomers() {
		if(customers == null){
			customers = new ArrayList<Customer>();
		}
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


}