package insurance.pty.model.enums;

public enum Gender {

	MALE("Male",1),
	FEMALE("Female",2),;
	
	private String name;
	private Integer id;
	
	private Gender(String name,Integer id){
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
