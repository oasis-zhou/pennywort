package insurance.fd.ratetable.model;

public class ValueFactor implements RateFactor{

	private String name;
	private String value;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean match(String input){
		return input.equals(this.value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
