package insurance.pa.model;

import insurance.fd.anno.FieldSpec;
import insurance.fd.model.BaseModel;

import java.math.BigDecimal;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 
 */
public class Deductible extends BaseModel{

	
	@FieldSpec(code = "deductible_deductibleAmount", name = "deductible amount")
	private BigDecimal deductibleAmount;

	@FieldSpec(code = "deductible_deductiblePercentage", name = "deductible percentage")
	private BigDecimal deductiblePercentage;
	private String deductibleFormula;
	
	public BigDecimal getDeductibleAmount() {
		return deductibleAmount;
	}
	public void setDeductibleAmount(BigDecimal deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}
	public BigDecimal getDeductiblePercentage() {
		return deductiblePercentage;
	}
	public void setDeductiblePercentage(BigDecimal deductiblePercentage) {
		this.deductiblePercentage = deductiblePercentage;
	}
	public String getDeductibleFormula() {
		return deductibleFormula;
	}
	public void setDeductibleFormula(String deductibleFormula) {
		this.deductibleFormula = deductibleFormula;
	}

}