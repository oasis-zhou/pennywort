package insurance.pa.model.enums;

public enum EndorsementStatus {

	QUOTATION("Endorsement Quotation", 10),
	UNDERWRITING("Endorsement Underwriting",20),
	REJECT("Endorsement Rejected",30),
	ISSUE("Endorsement Issued",90),
	UNDO("Endorsement Undoed",100);
	
	private String name;
	private Integer id;
	
	private EndorsementStatus(String name,Integer id){
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
