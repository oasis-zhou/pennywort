package insurance.pa.model.enums;

public enum LiabilityStatus {

	DELETED("Deleted", 0),
	INEFFECTIVE("Ineffective", 1),
	EFFECTIVE("Effective", 2),
	TERMINAL("Terminal", 3);
	
	private String name;
	private Integer id;
	
	private LiabilityStatus(String name,Integer id){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
