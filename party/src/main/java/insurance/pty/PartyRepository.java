package insurance.pty;

import insurance.pty.model.Party;

public interface PartyRepository {

	public Party savePartyRole(Party party);
	
	public Party loaPartyRole(Long id,Integer roleId);
}
