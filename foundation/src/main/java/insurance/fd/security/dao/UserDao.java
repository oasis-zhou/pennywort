package insurance.fd.security.dao;

import insurance.fd.security.OrganizationAware;
import insurance.fd.security.dao.pojo.TUser;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserDao extends CrudRepository<TUser, Long>, OrganizationAware {
	
	@Query("SELECT m  FROM #{#entityName} m")
	public List<TUser> findAllUsers();
	
	@Query("SELECT m  FROM #{#entityName} m WHERE m.username =:username")
	public TUser findByUsername(@Param("username") String username);
}
