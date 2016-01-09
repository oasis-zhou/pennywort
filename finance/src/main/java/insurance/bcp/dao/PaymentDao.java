package insurance.bcp.dao;

import insurance.bcp.dao.pojo.TPayment;
import insurance.fd.security.OrganizationAware;

import org.springframework.data.repository.CrudRepository;

public interface PaymentDao extends CrudRepository<TPayment, Long>, OrganizationAware{

}
