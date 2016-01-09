package insurance.bcp.model;

import java.util.List;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:20:05
 */
public class GeneralLedgerFee {

	private Integer bizTransaction;
	private String refBizNumber;
	private Integer currency;
	public List<FeeItem> feeItems;
	
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
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public List<FeeItem> getFeeItems() {
		return feeItems;
	}
	public void setFeeItems(List<FeeItem> feeItems) {
		this.feeItems = feeItems;
	}



}