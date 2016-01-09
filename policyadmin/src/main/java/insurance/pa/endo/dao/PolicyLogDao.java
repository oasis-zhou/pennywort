package insurance.pa.endo.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.endo.dao.pojo.TPolicyLog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PolicyLogDao  extends CrudRepository<TPolicyLog, Long>, OrganizationAware{

	@Query("SELECT m FROM #{#entityName} m WHERE m.endoId =:endoId and m.logType =:logType")
	public TPolicyLog findByGroupId(@Param("endoId") Long endoId,@Param("logType") Integer logType);

}
