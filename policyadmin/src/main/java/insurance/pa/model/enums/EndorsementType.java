package insurance.pa.model.enums;

public enum EndorsementType {

	BASIC_INFO("Basic Information Endorsement", 10),
	CANCELLATION("Cancellation Endorsement", 30);
	
	private String name;
	private Integer id;
	
	private EndorsementType(String name,Integer id){
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
