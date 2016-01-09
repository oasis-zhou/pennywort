package insurance.pd.model;	

import java.util.ArrayList;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:30:05
 */
public class CoverageSpec {

	private String uuid;
	private String name;
	private String code;
	private String description;
	private List<TagSpec> tags;
	private LimitSpec limit;
	private DeductibleSpec deductible;
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
	public LimitSpec getLimit() {
		return limit;
	}
	public void setLimit(LimitSpec limit) {
		this.limit = limit;
	}
	public DeductibleSpec getDeductible() {
		return deductible;
	}
	public void setDeductible(DeductibleSpec deductible) {
		this.deductible = deductible;
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