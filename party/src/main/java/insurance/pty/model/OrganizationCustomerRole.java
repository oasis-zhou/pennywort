package insurance.pty.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationCustomerRole extends Organization {

	private String fax;
	private PersonName contactPersonName;
	private List<Address> addresses;
	private boolean isPolicyHolder;
	
	public OrganizationCustomerRole(){
		this.setPartyRole(PartyRole.ORGANIZARION_CUSTOMER);
	}
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public PersonName getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(PersonName contactPersonName) {
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
	public boolean isPolicyHolder() {
		return isPolicyHolder;
	}
	public void setPolicyHolder(boolean isPolicyHolder) {
		this.isPolicyHolder = isPolicyHolder;
	}
	
}
