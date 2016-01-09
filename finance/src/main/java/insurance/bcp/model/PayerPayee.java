package insurance.bcp.model;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:19:50
 */
public class PayerPayee {

	private String name;
	private Integer idType;
	private String idNumber;
	private Integer payMode;
	public Account account;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Integer getPayMode() {
		return payMode;
	}
	public void setPayMode(Integer payMode) {
		this.payMode = payMode;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}


}