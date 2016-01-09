package insurance.pa.model;

import insurance.fd.anno.FieldSpec;
import insurance.fd.model.BaseModel;

import java.math.BigDecimal;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 
 */
public class Limit extends BaseModel {


	@FieldSpec(code = "limit_limitAmount", name = "limit amount")
	private BigDecimal limitAmount;
	@FieldSpec(code = "limit_limitNumber", name = "limit number")
	private BigDecimal limitNumber;
	@FieldSpec(code = "limit_unitAmount", name = "limit unit amount")
	private BigDecimal unitAmount;
	@FieldSpec(code = "limit_numberOfUnit", name = "limit number of unit")
	private BigDecimal numberOfUnit;
	@FieldSpec(code = "limit_unitType", name = "limit unit type")
	private String unitType;
	@FieldSpec(code = "limit_maxUnitAmount", name = "limit max unit amount")
	private BigDecimal maxUnitAmount;
	@FieldSpec(code = "limit_maxNumberOfUnit", name = "limit max uumber of unit")
	private BigDecimal maxNumberOfUnit;
	private String limitFormula;
	private String pattern;
	private String indemnityType;
	
	public BigDecimal getLimitAmount() {
		return limitAmount;
	}
	public void setLimitAmount(BigDecimal limitAmount) {
		this.limitAmount = limitAmount;
	}
	public BigDecimal getLimitNumber() {
		return limitNumber;
	}
	public void setLimitNumber(BigDecimal limitNumber) {
		this.limitNumber = limitNumber;
	}
	public BigDecimal getUnitAmount() {
		return unitAmount;
	}
	public void setUnitAmount(BigDecimal unitAmount) {
		this.unitAmount = unitAmount;
	}
	public BigDecimal getNumberOfUnit() {
		return numberOfUnit;
	}
	public void setNumberOfUnit(BigDecimal numberOfUnit) {
		this.numberOfUnit = numberOfUnit;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public BigDecimal getMaxUnitAmount() {
		return maxUnitAmount;
	}
	public void setMaxUnitAmount(BigDecimal maxUnitAmount) {
		this.maxUnitAmount = maxUnitAmount;
	}
	public BigDecimal getMaxNumberOfUnit() {
		return maxNumberOfUnit;
	}
	public void setMaxNumberOfUnit(BigDecimal maxNumberOfUnit) {
		this.maxNumberOfUnit = maxNumberOfUnit;
	}
	public String getLimitFormula() {
		return limitFormula;
	}
	public void setLimitFormula(String limitFormula) {
		this.limitFormula = limitFormula;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getIndemnityType() {
		return indemnityType;
	}
	public void setIndemnityType(String indemnityType) {
		this.indemnityType = indemnityType;
	}


}