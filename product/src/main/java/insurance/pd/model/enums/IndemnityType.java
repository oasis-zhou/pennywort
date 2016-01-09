package insurance.pd.model.enums;

public enum IndemnityType {

	AOA("Any one accident", "AOA"),
	AOP("Any one period", "AOP");
	
	private String name;
	private String id;
	
	private IndemnityType(String name,String id){
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
