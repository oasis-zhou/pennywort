package insurance.pty.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pty.dao.pojo.TPartyRole;

import org.springframework.data.repository.CrudRepository;

public interface PartyRoleDao extends CrudRepository<TPartyRole, Long>, OrganizationAware{

}
