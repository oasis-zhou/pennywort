package insurance.bcp.dao;

import insurance.bcp.dao.pojo.TCollection;
import insurance.fd.security.OrganizationAware;

import org.springframework.data.repository.CrudRepository;

public interface CollectionDao extends CrudRepository<TCollection, Long>, OrganizationAware{

}
