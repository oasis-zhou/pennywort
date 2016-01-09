package insurance.pa.model;

import insurance.pa.model.enums.EndorsementType;

/**
 * Created by littleMing on 15/5/19.
 */
public class BasicInfo extends Endorsement{

    public BasicInfo() {
    	this.setEndorsementType(EndorsementType.BASIC_INFO);
    }

}
