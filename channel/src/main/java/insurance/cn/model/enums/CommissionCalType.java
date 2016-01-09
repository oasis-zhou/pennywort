package insurance.cn.model.enums;

public enum CommissionCalType {

	FIX_AMOUNT("Fix amount","FixAmount"),
	RATE("Rate","Rate");
	
	private String name;
	private String id;
	
	private CommissionCalType(String name,String id){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
