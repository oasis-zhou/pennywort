package insurance.pd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 25-����-2015 15:30:52
 */
public class InsuredSpec {

	private Integer category;
	private List<TagSpec> tags;
	private List<FormulaSpec> formulas;
	
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
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