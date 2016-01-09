package insurance.pa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonCustomer extends Customer {

	private PersonName name;
	private Integer idType;
	private String idNumber;
	private String gender;
	private Date birthday;
	private String mobile;
	private String phone;
	private String mail;
	private List<Address> addresses;


	public PersonName getName() {
		return name;
	}
	public void setName(PersonName name) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<Address> getAddresses() {
		if(addresses == null){
			addresses = new ArrayList<Address>();
		}
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
