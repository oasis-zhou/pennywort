package insurance.fd.model;

import insurance.fd.pub.Guid;

import java.util.HashMap;
import java.util.Map;

public class BaseModel {

	private String uuid;
	
	private Map dynamicFields = new HashMap();
	
	public BaseModel(){
		String id = Guid.generateUuid();
	    this.uuid = id; 
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Map getDynamicFields() {
		return dynamicFields;
	}

	public void setDynamicFields(Map dynamicFields) {
		this.dynamicFields = dynamicFields;
	}
	
	
}
