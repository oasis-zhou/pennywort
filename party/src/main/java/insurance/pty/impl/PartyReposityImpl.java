package insurance.pty.impl;

import insurance.fd.utils.JsonHelper;
import insurance.pty.PartyRepository;
import insurance.pty.dao.PartyDao;
import insurance.pty.dao.PartyRoleDao;
import insurance.pty.dao.pojo.TParty;
import insurance.pty.dao.pojo.TPartyRole;
import insurance.pty.model.Organization;
import insurance.pty.model.Party;
import insurance.pty.model.Person;
import insurance.pty.model.enums.PartyCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyReposityImpl implements PartyRepository {

	@Autowired
	private PartyDao partyDao;
	@Autowired
	private PartyRoleDao partyRoleDao;
	@Autowired
	private JsonHelper jsonHelper;

	@Override
	public Party savePartyRole(Party party) {
		TParty partyPO = null;
		if(party.getId() != null){
			partyPO= partyDao.findOne(party.getId());
		}else{
			partyPO= new TParty();
		}

		if(party.getCategory().getId() == PartyCategory.PERSON.getId()){

			partyPO.setName(((Person)party).getName().getFullName());
			partyPO.setIdType(((Person)party).getIdType());
			partyPO.setIdNumber(((Person)party).getIdNumber());
			partyPO.setGender(((Person)party).getGender().getId());
			partyPO.setBirthday(((Person)party).getBirthday());
			partyPO.setPhone(((Person)party).getPhone());
			partyPO.setEmail(((Person)party).getEmail());
		}else {
			partyPO.setName(((Organization)party).getName());
			partyPO.setIdType(((Organization)party).getIdType());
			partyPO.setIdNumber(((Organization)party).getIdNumber());
			partyPO.setPhone(((Organization)party).getPhone());
			partyPO.setEmail(((Organization)party).getEmail());
		}

		TPartyRole partyRolePO = null;

		if(partyPO.getPartyRoles().size() > 0){
			for(TPartyRole role : partyPO.getPartyRoles()){
				if(role.getPartyRole() == party.getPartyRole().getId()){
					partyRolePO = role;
				}
			}
		}

		if(partyRolePO == null){
			partyRolePO = new TPartyRole();
			partyRolePO.setParty(partyPO);
			partyPO.getPartyRoles().add(partyRolePO);
		}

		partyRolePO.setPartyRole(party.getPartyRole().getId());

		String content = jsonHelper.toJSON(party);
		partyRolePO.setContent(content);

		TParty p = partyDao.save(partyPO);
		party.setId(p.getId());

		return party;
	}

	@Override
	public Party loaPartyRole(Long id,Integer roleId) {
		Party party = null;

		TParty partyPO= partyDao.findOne(id);

		TPartyRole partyRolePO = null;
		if(partyPO.getPartyRoles().size() > 0){
			for(TPartyRole role : partyPO.getPartyRoles()){
				if(role.getPartyRole() == roleId){
					partyRolePO = role;
				}
			}
		}

		if(partyRolePO != null){
			party = jsonHelper.fromJSON(partyRolePO.getContent(), Party.class);
			party.setId(id);
		}

		return party;
	}

}
