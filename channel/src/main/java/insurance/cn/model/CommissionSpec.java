package insurance.cn.model;

import java.math.BigDecimal;

public class CommissionSpec {
	
	private String calculationType;
	private Boolean isRealTime;
	private BigDecimal value;
	
	public String getCalculationType() {
		return calculationType;
	}
	public void setCalculationType(String calculationType) {
		this.calculationType = calculationType;
	}
	public Boolean getIsRealTime() {
		return isRealTime;
	}
	public void setIsRealTime(Boolean isRealTime) {
		this.isRealTime = isRealTime;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
}
