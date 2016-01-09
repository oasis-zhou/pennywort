package insurance.pa.model.enums;

public enum EndorsementAplyType {

	APLY_BY_INSURER("Application by Insurer", 1),
	APLY_BY_POLICY_HOLDER("Application by Policy Holder", 2),
	APLY_BY_UNDERWRITER("Application by Underwriter", 3);
	
	private String name;
	private Integer id;
	
	private EndorsementAplyType(String name,Integer id){
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

	public static EndorsementAplyType getTypeById(Integer id) {
		for (EndorsementAplyType t : EndorsementAplyType.values()) {
			if (t.getId() == id)
				return t;
		}
		return null;
	}
	
	
}
