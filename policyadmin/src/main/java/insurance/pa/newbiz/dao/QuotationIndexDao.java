package insurance.pa.newbiz.dao;

import insurance.fd.security.OrganizationAware;
import insurance.pa.newbiz.dao.pojo.TQuotationIndex;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuotationIndexDao extends CrudRepository<TQuotationIndex, Long>, OrganizationAware{

	@Query("select a from TQuotationIndex a where a.quotationId = :quotationId")
	public TQuotationIndex findQuotationIndexByQuotationId(@Param("quotationId") Long quotationId);
}
