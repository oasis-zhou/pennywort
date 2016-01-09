package insurance.bcp.dao;

import insurance.bcp.dao.pojo.TGLFee;
import insurance.fd.security.OrganizationAware;

import org.springframework.data.repository.CrudRepository;

public interface GeneralLedgerFeeDao extends CrudRepository<TGLFee, Long>, OrganizationAware{

}
