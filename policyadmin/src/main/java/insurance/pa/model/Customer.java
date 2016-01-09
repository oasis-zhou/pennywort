package insurance.pa.model;

import insurance.fd.model.BaseModel;

public class Customer extends BaseModel{

	private boolean isPolicyHolder;
	private boolean isInsured;
	private Integer partyCategory;

	public boolean isPolicyHolder() {
		return isPolicyHolder;
	}

	public void setPolicyHolder(boolean isPolicyHolder) {
		this.isPolicyHolder = isPolicyHolder;
	}

	public boolean isInsured() {
		return isInsured;
	}

	public void setInsured(boolean isInsured) {
		this.isInsured = isInsured;
	}

    public Integer getPartyCategory() {
        return partyCategory;
    }

    public void setPartyCategory(Integer partyCategory) {
        this.partyCategory = partyCategory;
    }
	

}
