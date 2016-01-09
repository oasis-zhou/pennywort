package insurance.pa.model.enums;

public enum LogType {

	ISSUE_LOG("Issue Log",1),
	INVALID_ISSUE_LOG("Invalid Issue Log",2);
	
	
	private String name;
	private Integer id;
	
	private LogType(String name,Integer id){
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
