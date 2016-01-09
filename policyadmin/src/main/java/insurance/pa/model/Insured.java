package insurance.pa.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import insurance.fd.model.BaseModel;
import insurance.pa.model.enums.LiabilityStatus;
import insurance.pa.model.other.GRInsured;
import insurance.price.model.Fee;
import insurance.price.model.ModelWithFee;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "typeName")
@JsonSubTypes({@JsonSubTypes.Type(value=GRInsured.class,name = "GRInsured")})
public abstract class Insured extends BaseModel implements ModelWithFee{

	private LiabilityStatus status;
	private String insuredName;
	private Integer insuredCategory;
	private Integer terminalReason;
	private BigDecimal AOALimitAmount;
	private BigDecimal AOPLimitAmount;
	private Fee fee;

	public abstract List<Coverage> getCoverages();

	public LiabilityStatus getStatus() {
		return status;
	}
	public void setStatus(LiabilityStatus status) {
		this.status = status;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public Integer getInsuredCategory() {
		return insuredCategory;
	}
	public void setInsuredCategory(Integer insuredCategory) {
		this.insuredCategory = insuredCategory;
	}
	public Integer getTerminalReason() {
		return terminalReason;
	}
	public void setTerminalReason(Integer terminalReason) {
		this.terminalReason = terminalReason;
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


}