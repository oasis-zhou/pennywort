package insurance.pa.price;

import insurance.AbstractTest;
import insurance.pa.endo.EndorsementRepository;
import insurance.pa.endo.EndorsementService;
import insurance.pa.model.Cancellation;
import insurance.pa.model.Policy;
import insurance.pa.model.enums.EndorsementStatus;
import insurance.pa.model.enums.EndorsementType;
import insurance.pa.newbiz.PolicyRepository;
import insurance.price.PricingProcess;
import insurance.price.model.FeeItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EndoPriceTest extends AbstractTest{

	@Resource(name = "NewbizPremiumProcess")
	private PricingProcess<Policy> newbizProcess;
	
	@Resource(name = "EndoPremiumProcess")
	PricingProcess endoProcess;
	
	@Autowired
	PolicyRepository policyService;

	@Autowired
	EndorsementService endoService;
	
	@Autowired
	private EndorsementRepository endoRepository;
	
	@Test	
	public void calculatePremium(){
		System.out.print("************** Calculate Endorsement Premium *********************\n");
		try{
			Policy policy = this.createPolicyFromFile();
			
			newbizProcess.launch(policy);
			policyService.savePolicy(policy);
			Long policyId = (Long)policy.getPolicyId();

			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");	
			String str="2016-01-01";	
			Date effDate = sim.parse(str);

			Cancellation endo = new Cancellation();
			endo.setPolicyId(policyId);
			endo.setEffectiveDate(effDate);	
			endo.setEndorsementStatus(EndorsementStatus.QUOTATION);
			endo.setEndorsementType(EndorsementType.CANCELLATION);

			endoRepository.create(endo);

			endoService.calculate(endo);

			List<FeeItem> fees = endo.getFee().getItems();

			for(FeeItem fee : fees){
				System.out.print("Total fee List:" + fee.getFeeType() + "==" + fee.getAmount() + "\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
