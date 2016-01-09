package insurance.pa.model.enums;

public enum ContractStatus {

	INEFFECTIVE("Ineffective", 1),
	EFFECTIVE("Effective", 2),
	TERMINAL("Terminal", 3);
	
	private String name;
	private Integer id;
	
	private ContractStatus(String name,Integer id){
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
