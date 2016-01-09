package insurance.pd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:31:07
 */
public class FormulaSpec {

	private String uuid;
	private String aim;
	private String name;
	private List<String> factors;
	private String body;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAim() {
		return aim;
	}
	public void setAim(String aim) {
		this.aim = aim;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFactors() {
		if(factors == null){
			factors = new ArrayList<String>();
		}
		return factors;
	}
	public void setFactors(List<String> factors) {
		this.factors = factors;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	

}