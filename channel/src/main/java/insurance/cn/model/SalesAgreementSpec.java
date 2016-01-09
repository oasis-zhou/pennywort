package insurance.cn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesAgreementSpec {

	private String uuid;
	private String name;
	private Date effectiveDate;
	private Date expiredDate;
	private String description;
	private String productId;
	private SalesSettlementSpec settlement;
	private CommissionSpec commission;
	private List<String> services;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public SalesSettlementSpec getSettlement() {
		return settlement;
	}
	public void setSettlement(SalesSettlementSpec settlement) {
		this.settlement = settlement;
	}
	public CommissionSpec getCommission() {
		return commission;
	}
	public void setCommission(CommissionSpec commission) {
		this.commission = commission;
	}
	public List<String> getServices() {
		if(services == null){
			services = new ArrayList<String>();
		}
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}

}
