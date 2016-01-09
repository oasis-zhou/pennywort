package insurance.pd.model;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:30:14
 */
public class LimitSpec {

	private String pattern;
	private String value;
	private String indemnityType;
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIndemnityType() {
		return indemnityType;
	}
	public void setIndemnityType(String indemnityType) {
		this.indemnityType = indemnityType;
	}


}