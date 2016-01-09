package insurance.bcp.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:18:52
 */
public class FinanceTransaction {

	private String transNumber;
	private Integer transType;
	private Date transDate;
	private BigDecimal amount;
	
	public String getTransNumber() {
		return transNumber;
	}
	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}
	public Integer getTransType() {
		return transType;
	}
	public void setTransType(Integer transType) {
		this.transType = transType;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}