package insurance.pa.model;

import java.util.Date;

public abstract class StandardPolicy extends Policy {

	private String productCode;
	private String quotationNumber;
	private Date quotationDate;
	private Integer terminalReason;
	private Long currency;	
	private Long creater;
	private Long currentOperater;
	private Integer rejectReason;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getQuotationNumber() {
		return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}
	public Date getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
	public Integer getTerminalReason() {
		return terminalReason;
	}
	public void setTerminalReason(Integer terminalReason) {
		this.terminalReason = terminalReason;
	}
	public Long getCurrency() {
		return currency;
	}
	public void setCurrency(Long currency) {
		this.currency = currency;
	}
	public Long getCreater() {
		return creater;
	}
	public void setCreater(Long creater) {
		this.creater = creater;
	}
	public Long getCurrentOperater() {
		return currentOperater;
	}
	public void setCurrentOperater(Long currentOperater) {
		this.currentOperater = currentOperater;
	}
	public Integer getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(Integer rejectReason) {
		this.rejectReason = rejectReason;
	}

}
