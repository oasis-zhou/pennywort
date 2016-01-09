package insurance.bcp.dao;

import insurance.bcp.dao.pojo.TCPFee;
import insurance.fd.security.OrganizationAware;

import org.springframework.data.repository.CrudRepository;

public interface CollectionPaymentFeeDao extends CrudRepository<TCPFee, Long>, OrganizationAware{

}
