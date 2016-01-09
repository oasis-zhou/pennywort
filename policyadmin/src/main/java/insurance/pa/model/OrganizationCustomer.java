package insurance.pa.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationCustomer extends Customer {

	private String name;
	private String registrationNo;
	private String phone;
	private String mail;
	private String fax;
	private String contactPersonName;
	private List<Address> addresses;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
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
