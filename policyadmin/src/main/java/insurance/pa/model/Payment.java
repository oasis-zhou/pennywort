package insurance.pa.model;

import insurance.fd.model.BaseModel;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015 
 */
public class Payment extends BaseModel{

	private Integer paymentPlan;

	public Integer getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(Integer paymentPlan) {
		this.paymentPlan = paymentPlan;
	}
	

}