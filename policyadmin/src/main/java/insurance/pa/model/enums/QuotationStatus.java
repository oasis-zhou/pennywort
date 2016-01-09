package insurance.pa.model.enums;

public enum QuotationStatus {

	QUOTATION_INPROCESS("Quotation in process",10),
	UNDERWRITING_INPROCESS("Underwriting in process",20),
	ISSUED("Issued",100),
	REJECTED("Rejected",90);
	
	private String name;
	private Integer id;
	
	private QuotationStatus(String name,Integer id){
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
