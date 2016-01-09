package insurance.pa.model.enums;

public enum CancellationType {

	CANCELLATION_FROM_INCEPTION("Cancellation from Inception",1),
	CANCELLATION_MIDWAY("Cancellation Midway",2);
	
	private String name;
	private Integer id;
	
	private CancellationType(String name,Integer id){
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
