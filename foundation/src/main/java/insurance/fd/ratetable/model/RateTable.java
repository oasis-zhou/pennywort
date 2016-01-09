package insurance.fd.ratetable.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RateTable {

	private String name;
	private String code;
	private Date effectiveDate;
	private Date expiredDate;
	private String description;
	private Boolean valid;
	private String version;

	private List<RateItem> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<RateItem> getItems() {
		if(items == null){
			items = new ArrayList<RateItem>();
		}
		return items;
	}

	public void setItems(List<RateItem> items) {
		this.items = items;
	}
	
	
}
