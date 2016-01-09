package insurance.pd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:29:56
 */
public class ProductSpec {

	private String uuid;
	private String name;
	private String code;
	private String version;
	private Date effectiveDate;
	private Date expiredDate;
	private Boolean valid;
	private String description;
	private List<TagSpec> tags;
	private List<CoverageSpec> coverages;
	private InsuredSpec insured;
	private List<RuleSetSpec> ruleSets;
	private List<FormulaSpec> formulas;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<TagSpec> getTags() {
		if(tags == null){
			tags = new ArrayList<TagSpec>();
		}
		return tags;
	}
	public void setTags(List<TagSpec> tags) {
		this.tags = tags;
	}
	public List<CoverageSpec> getCoverages() {
		if(coverages == null){
			coverages = new ArrayList<CoverageSpec>();
		}
		return coverages;
	}
	public void setCoverages(List<CoverageSpec> coverages) {
		this.coverages = coverages;
	}
	public InsuredSpec getInsured() {
		return insured;
	}
	public void setInsured(InsuredSpec insured) {
		this.insured = insured;
	}
	public List<RuleSetSpec> getRuleSets() {
		if(ruleSets == null){
			ruleSets = new ArrayList<RuleSetSpec>();
		}
		return ruleSets;
	}
	public void setRuleSets(List<RuleSetSpec> ruleSets) {
		this.ruleSets = ruleSets;
	}
	public List<FormulaSpec> getFormulas() {
		if(formulas == null){
			formulas = new ArrayList<FormulaSpec>();
		}
		return formulas;
	}
	public void setFormulas(List<FormulaSpec> formulas) {
		this.formulas = formulas;
	}


}