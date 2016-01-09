package insurance.pty.model;

import insurance.fd.model.BaseModel;
import insurance.pty.model.enums.PartyCategory;

public class Party extends BaseModel{
	private Long id;
	private PartyCategory category;
	private PartyRole partyRole; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PartyCategory getCategory() {
		return category;
	}
	public void setCategory(PartyCategory category) {
		this.category = category;
	}
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}	
	
}
