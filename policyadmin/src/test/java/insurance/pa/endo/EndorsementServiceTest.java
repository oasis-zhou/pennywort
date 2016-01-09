package insurance.pa.endo;

import insurance.AbstractTest;
import insurance.pa.model.Cancellation;
import insurance.pa.model.Endorsement;
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

public class EndorsementServiceTest extends AbstractTest{

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
	public void create(){
		System.out.print("**************Create Endorsement*********************\n");
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
			
//			Map dataContext = new HashMap();
//			dataContext.put(EndoValidationConstant.ENDORSEMENT_MODEL, endo);
//			ValidationResult result = vService.validate("CreateEndorsementRuleSet", dataContext);

//			System.out.print("Endorsement validation result ==" + result.isFailed() + "  message==" + result.getMessages() + "\n");
//			
//			if(result.isFailed())
//				return;
			
			Long endoId = endoRepository.create(endo);

			System.out.print("Endorsement id==" + endoId + "\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void load(){
		System.out.print("**************Create Endorsement*********************\n");
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

			Long endoId = endoRepository.create(endo);
			
			Endorsement lendo = endoRepository.load(endoId);

			System.out.print("Endorsement id==" + lendo.getEndorsementId() + "\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void reject(){
		System.out.print("**************Reject Endorsement*********************\n");
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

			endoService.reject(endo.getEndorsementId());

			System.out.print("Endorsement id==" + endo.getEndorsementId() + "\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void calculate(){
		System.out.print("**************Calculate Endorsement Premium*********************\n");
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

	@Test
	public void issue(){
		System.out.print("**************Issue Endorsement *********************\n");
		try{
			Policy policy = this.createPolicyFromFile();
			newbizProcess.launch(policy);
			policyService.savePolicy(policy);
			Long policyId = (Long)policy.getPolicyId();

			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");	
			String str="2015-01-01";	
			Date effDate = sim.parse(str);

			Cancellation endo = new Cancellation();
			endo.setPolicyId(policyId);
			endo.setEffectiveDate(effDate);	
			endo.setEndorsementStatus(EndorsementStatus.QUOTATION);
			endo.setEndorsementType(EndorsementType.CANCELLATION);

			endoRepository.create(endo);
//			
//			Map dataContext = new HashMap();
//			dataContext.put(EndoValidationConstant.ENDORSEMENT_MODEL, endo);
//			ValidationResult result = vService.validate("IssueEndorsementRuleSet", dataContext);
//
//			System.out.print("Endorsement validation result ==" + result.isFailed() + "  message==" + result.getMessages() + "\n");
//			
//			if(result.isFailed())
//				return;

			endoService.calculate(endo);

			endoService.issue(endo);

			String endoNumber = endo.getEndorsementNumber();

			System.out.print("Endorsement number==" + endoNumber + "\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
