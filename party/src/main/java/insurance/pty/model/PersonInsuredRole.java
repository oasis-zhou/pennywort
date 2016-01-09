package insurance.pty.model;

import java.util.ArrayList;
import java.util.List;

public class PersonInsuredRole extends Person {
	
	private PartyRole partyRole = PartyRole.PERSON_INSURED;
	private Integer occupation;
	private String fullAddress;
	private List<Address> addresses;
	
	
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}
	public Integer getOccupation() {
		return occupation;
	}
	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
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
