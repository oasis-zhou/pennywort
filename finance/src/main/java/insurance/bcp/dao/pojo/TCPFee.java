package insurance.bcp.dao.pojo;

import insurance.fd.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class TCPFee extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8008224271089475487L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private Integer bizTransaction;
	@Column
	private String refBizNumber;
	@Column
	private String refExtNumber;
	@Column
	private Integer feeType;
	@Column
	private BigDecimal amount;
	@Column
	private BigDecimal balance;
	@Column
	private Integer currency;
	@Column
	private Date creationDate;
	@Column
	private Date dueDate;
	@Column
	private String payerPayeeName;
	@Lob
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBizTransaction() {
		return bizTransaction;
	}
	public void setBizTransaction(Integer bizTransaction) {
		this.bizTransaction = bizTransaction;
	}
	public String getRefBizNumber() {
		return refBizNumber;
	}
	public void setRefBizNumber(String refBizNumber) {
		this.refBizNumber = refBizNumber;
	}
	public String getRefExtNumber() {
		return refExtNumber;
	}
	public void setRefExtNumber(String refExtNumber) {
		this.refExtNumber = refExtNumber;
	}
	public Integer getFeeType() {
		return feeType;
	}
	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getPayerPayeeName() {
		return payerPayeeName;
	}
	public void setPayerPayeeName(String payerPayeeName) {
		this.payerPayeeName = payerPayeeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
