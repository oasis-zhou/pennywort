package insurance.claim.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class ClaimParty {
	/**
	 * Claim Party Id(PK)
	 */	
	private Long claimPartyId;
	/**
	 * 客户姓名
	 */
	@NotNull(message="索赔人姓名为空")
	private String customerName;
	/**
	 * 证件类型(身份证/护照)
	 */
	@NotNull(message="索赔人证件类型为空")
	private Integer idType;
	/**
	 * 证件号码
	 */
	@NotNull(message="索赔人证件号码为空")
	private String idNumber;
	/**
	 * 帐号
	 */
	private String accountNumber;
	/**
	 * 账户类型（银行/支付宝）
	 */
	private Integer accountType;
	/**
	 * 账户名称
	 */
	private String accountName;
	/**
	 * 银行代码
	 */
	private String bankCode;
	/**
	 * 邮箱
	 */
	@Email(message="邮箱格式不正确")
	private String email;
	/**
	 * 手机
	 */
	@Pattern(regexp = "^1\\d{10}$",	message="手机号码格式不正确")
	private String mobile;
	
	public Long getClaimPartyId() {
		return claimPartyId;
	}
	public void setClaimPartyId(Long claimPartyId) {
		this.claimPartyId = claimPartyId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
}
