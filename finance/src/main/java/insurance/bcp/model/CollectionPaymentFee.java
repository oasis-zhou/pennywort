package insurance.bcp.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:19:33
 */
public class CollectionPaymentFee {

	private Integer bizTransaction;
	private String refBizNumber;
	private String refExtNumber;
	private Integer feeType;
	private BigDecimal amount;
	private BigDecimal balance;
	private Integer currency;
	private Date creationDate;
	private Date dueDate;
	public PayerPayee payerPayee;
	
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
	public PayerPayee getPayerPayee() {
		return payerPayee;
	}
	public void setPayerPayee(PayerPayee payerPayee) {
		this.payerPayee = payerPayee;
	}


}