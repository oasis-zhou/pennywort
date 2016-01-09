package insurance.pa.model;

import insurance.fd.anno.FieldSpec;
import insurance.fd.model.BaseModel;
import insurance.pa.model.enums.LiabilityStatus;
import insurance.price.model.Fee;
import insurance.price.model.ModelWithFee;

import java.math.BigDecimal;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 
 */
public class Coverage extends BaseModel implements ModelWithFee{

	private String name;
	@FieldSpec(code = "coverage_coverageId", name = "coverage spec uuid")
	private String coverageId;
	@FieldSpec(code = "coverage_code", name = "coverage spec code")
	private String code;
	private LiabilityStatus status;
	@FieldSpec(code = "coverage_AOALimitAmount", name = "coverage AOA limit amount")
	private BigDecimal AOALimitAmount;
	@FieldSpec(code = "coverage_AOPLimitAmount", name = "coverage AOP limit amount")
	private BigDecimal AOPLimitAmount;
	private Limit limit;
	private Deductible deductible;
	private Fee fee;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoverageId() {
		return coverageId;
	}
	public void setCoverageId(String coverageId) {
		this.coverageId = coverageId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LiabilityStatus getStatus() {
		return status;
	}
	public void setStatus(LiabilityStatus status) {
		this.status = status;
	}
	public BigDecimal getAOALimitAmount() {
		return AOALimitAmount;
	}
	public void setAOALimitAmount(BigDecimal aOALimitAmount) {
		AOALimitAmount = aOALimitAmount;
	}
	public BigDecimal getAOPLimitAmount() {
		return AOPLimitAmount;
	}
	public void setAOPLimitAmount(BigDecimal aOPLimitAmount) {
		AOPLimitAmount = aOPLimitAmount;
	}
	public Fee getFee() {
		if(fee == null){
			fee = new Fee(this.getUuid(),this.getClass().getSimpleName());
		}
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	public Limit getLimit() {
		return limit;
	}
	public void setLimit(Limit limit) {
		this.limit = limit;
	}
	public Deductible getDeductible() {
		return deductible;
	}
	public void setDeductible(Deductible deductible) {
		this.deductible = deductible;
	}
	
	


}