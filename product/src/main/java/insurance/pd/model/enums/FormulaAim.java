package insurance.pd.model.enums;

public enum FormulaAim {

	GROSS_PREMIUM("Premium","GROSS-PREMIUM"),
	NET_PREMIUM("Premium","NET-PREMIUM"),
	TAX_FEE("Tax Fee","TAX-FEE"),
	COMMISSION("Commission","COMMISSION"),
	ADD_REFUND_PREMIUM("Premium","ADD_REFUND_PREMIUM");
	
	private String name;
	private String id;
	
	private FormulaAim(String name,String id){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
