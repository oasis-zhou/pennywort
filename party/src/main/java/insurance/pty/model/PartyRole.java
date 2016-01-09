package insurance.pty.model;

public enum PartyRole {

	PERSON_CUSTOMER("Person Customer",10),
	ORGANIZARION_CUSTOMER("Organization Customer",20),
	DRIVER("Driver",11),
	PERSON_INSURED("Person Insured",12),;
	
	private String name;
	private Integer id;
	
	private PartyRole(String name,Integer id){
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
