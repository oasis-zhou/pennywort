package insurance.pty.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pty.dao.pojo.TParty;

import org.springframework.data.repository.CrudRepository;

public interface PartyDao extends CrudRepository<TParty, Long>, OrganizationAware{

}
