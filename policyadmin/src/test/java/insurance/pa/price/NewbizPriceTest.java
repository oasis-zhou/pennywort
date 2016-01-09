package insurance.pa.price;

import insurance.AbstractTest;
import insurance.fd.utils.JsonHelper;
import insurance.pa.model.Coverage;
import insurance.pa.model.Limit;
import insurance.pa.model.Policy;
import insurance.pa.model.enums.LiabilityStatus;
import insurance.pa.model.other.GRInsured;
import insurance.pa.model.other.GRPolicy;
import insurance.price.PricingProcess;
import insurance.price.model.FeeItem;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NewbizPriceTest extends AbstractTest{

	@Resource(name = "NewbizPremiumProcess")
	private PricingProcess<Policy> process;
	
	@Autowired
	private JsonHelper jsonHelper;
	
	@Test
	public void calculatePremium(){
		
		Policy policy = this.createPolicyFromFile();
		
		process.launch(policy);
		
		List<FeeItem> fees = policy.getFee().getItems();
		System.out.print("Total AOA limit==" + policy.getAOALimitAmount()  + "\n");
		System.out.print("Total AOP limit==" + policy.getAOPLimitAmount()  + "\n");

		for(FeeItem fee : fees){
			System.out.print("Total fee List:" + fee.getFeeType() + "==" + fee.getAmount() + "\n");
		}
		
		System.out.print("####policy uuid=" + policy.getUuid());
	}

//	@Test
	public void generatePolicy(){

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		GRPolicy policy = new GRPolicy();
		policy.setProductId("GR:1");
		policy.setChannelId("TAOBAO");
		try{
			policy.setEffectiveDate(dateFormat.parse("2015-01-01"));
			policy.setExpiredDate(dateFormat.parse("2016-12-31"));
		}catch(Exception e){

		}

		GRInsured insured = new GRInsured();
		insured.setInsuredCategory(9);
		insured.setStatus(LiabilityStatus.EFFECTIVE);
		policy.setInsured(insured);

		Coverage coverage = new Coverage();
		coverage.setCoverageId("GRC");
		coverage.setCode("GRC");
		coverage.setStatus(LiabilityStatus.EFFECTIVE);
		insured.getCoverages().add(coverage);

		Limit limit = new Limit();
		limit.setIndemnityType("AOA");
		limit.setPattern("${limitAmount}");
		limit.setLimitAmount(new BigDecimal(9.00));
		coverage.setLimit(limit);


		String pJson = jsonHelper.toJSON(policy);

		System.out.print("####policy json=" + pJson);

	}
}
