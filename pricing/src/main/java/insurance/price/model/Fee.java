package insurance.price.model;

import java.util.ArrayList;
import java.util.List;

public class Fee implements ModelWithFee{
	
	private String refBusinessObjName;
	private String refBusinessObjUid;
	
	private List<FeeItem> items;	
	private List<Fee> subFees;
	
	@Override
	public Fee getFee(){
		return this;
	}
	
	public Fee(){	
	}
	
	public Fee(String refBusinessObjUid,String refBusinessObjName){
		this.refBusinessObjUid = refBusinessObjUid;
		this.refBusinessObjName = refBusinessObjName;
	}
	
	public String getRefBusinessObjName() {
		return refBusinessObjName;
	}
	public void setRefBusinessObjName(String refBusinessObjName) {
		this.refBusinessObjName = refBusinessObjName;
	}
	public String getRefBusinessObjUid() {
		return refBusinessObjUid;
	}
	public void setRefBusinessObjUid(String refBusinessObjUid) {
		this.refBusinessObjUid = refBusinessObjUid;
	}
	public List<FeeItem> getItems() {
		if(items == null){
			items = new ArrayList<FeeItem>();
		}
		return items;
	}
	public void setItems(List<FeeItem> items) {
		this.items = items;
	}
	public List<Fee> getSubFees() {
		if(subFees == null){
			subFees = new ArrayList<Fee>();
		}
		return subFees;
	}
	public void setSubFees(List<Fee> subFees) {
		this.subFees = subFees;
	}
	
	
}
