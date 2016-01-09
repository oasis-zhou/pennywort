package insurance.pd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:30:35
 */
public class RuleSetSpec {

	private String uuid;
	private String name;
	public List<RuleSpec> rules;
	
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
	public List<RuleSpec> getRules() {
		if(rules == null){
			rules = new ArrayList<RuleSpec>();
		}
		return rules;
	}
	public void setRules(List<RuleSpec> rules) {
		this.rules = rules;
	}

	

}