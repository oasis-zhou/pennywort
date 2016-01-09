package insurance.bcp;

import insurance.bcp.model.Collection;
import insurance.bcp.model.CollectionPaymentFee;
import insurance.bcp.model.GeneralLedgerFee;
import insurance.bcp.model.Payment;

public interface BcpService {
	
	public void postCollectionPaymentFee(CollectionPaymentFee fee);
	
	public void postGeneralLedgerFee(GeneralLedgerFee fee);

	public void doCollection(Collection collection);
	
	public void doPayment(Payment payment);
}
