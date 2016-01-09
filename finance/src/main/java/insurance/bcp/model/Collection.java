package insurance.bcp.model;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:19:01
 */
public class Collection extends FinanceTransaction {

	private String refBizNumber;
	private String refExtNumber;
	private PayerPayee payer;
	private Account collectionAccount;
	
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
	public PayerPayee getPayer() {
		return payer;
	}
	public void setPayer(PayerPayee payer) {
		this.payer = payer;
	}
	public Account getCollectionAccount() {
		return collectionAccount;
	}
	public void setCollectionAccount(Account collectionAccount) {
		this.collectionAccount = collectionAccount;
	}

}