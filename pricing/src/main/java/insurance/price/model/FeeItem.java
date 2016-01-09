package insurance.price.model;

import java.math.BigDecimal;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 
 */
public class FeeItem {

	private String feeType;
	private BigDecimal amount;
	private Integer source;
	
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}


}