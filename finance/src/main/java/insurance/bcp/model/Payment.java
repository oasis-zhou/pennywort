package insurance.bcp.model;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:19:10
 */
public class Payment extends FinanceTransaction {

	private String refBizNumber;
	private String refExtNumber;
	private PayerPayee payee;
	private Account paymentAccount;
	
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
	public PayerPayee getPayee() {
		return payee;
	}
	public void setPayee(PayerPayee payee) {
		this.payee = payee;
	}
	public Account getPaymentAccount() {
		return paymentAccount;
	}
	public void setPaymentAccount(Account paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

}