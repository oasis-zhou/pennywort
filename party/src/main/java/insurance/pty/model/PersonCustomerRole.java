package insurance.pty.model;

import java.util.ArrayList;
import java.util.List;

public class PersonCustomerRole extends Person {

	private List<Address> addresses;
	private boolean isPolicyHolder;
	
	public PersonCustomerRole(){
		this.setPartyRole(PartyRole.PERSON_CUSTOMER);
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
