package insurance.pd.model;

import java.util.Map;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:31:15
 */
public class RateTableSpec {

	private String uuid;
	private String name;
	private Map rateItem;
	
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
	public Map getRateItem() {
		return rateItem;
	}
	public void setRateItem(Map rateItem) {
		this.rateItem = rateItem;
	}


}