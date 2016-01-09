package insurance.bcp.model;


/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 15:19:44
 */
public class Account {

	private Integer type;
	private String accountNo;
	private String name;
	private String bank;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

}