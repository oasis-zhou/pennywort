package insurance.bcp.model;

import java.math.BigDecimal;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:19:58
 */
public class FeeItem {

	private Integer feeType;
	private BigDecimal amount;
	
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


}