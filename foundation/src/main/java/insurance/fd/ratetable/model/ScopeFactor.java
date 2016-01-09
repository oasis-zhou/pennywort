package insurance.fd.ratetable.model;

public class ScopeFactor implements RateFactor{

	private String name;
	private String maxFactor;
	private String minFactor;
	
	public Boolean match(String input){
		int c1 = input.compareTo(minFactor);
		int c2 = input.compareTo(maxFactor);
		if(c1 >= 0 && c2 < 0){
			return true;
		}else{
			return false;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaxFactor() {
		return maxFactor;
	}
	public void setMaxFactor(String maxFactor) {
		this.maxFactor = maxFactor;
	}
	public String getMinFactor() {
		return minFactor;
	}
	public void setMinFactor(String minFactor) {
		this.minFactor = minFactor;
	}
	
	
}
