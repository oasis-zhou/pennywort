package insurance.pa.price.model;

import insurance.fd.model.BaseModel;
import insurance.pa.endo.PolicyLogService;
import insurance.pa.model.Coverage;
import insurance.pa.model.Endorsement;
import insurance.pa.model.Insured;
import insurance.pa.model.Policy;
import insurance.pa.model.enums.LiabilityStatus;
import insurance.pa.model.enums.LogType;
import insurance.pa.newbiz.PolicyRepository;
import insurance.price.Calculator;
import insurance.price.PricingConstant;
import insurance.price.model.Fee;
import insurance.price.model.FeeItem;
import insurance.price.model.PricingModel;
import insurance.price.model.PricingModelBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class EndoPremiumModelBuilder implements PricingModelBuilder<Endorsement> {

	private Calculator calculator;

	@Autowired
	private PolicyLogService logService;

	@Autowired
	private PolicyRepository policyService;

	@Override
	public PricingModel build(Endorsement bizObject){

		PricingModel root = new PricingModel();
		Fee fee = bizObject.getFee();
	
		root.setRefObject(fee);
		root.setSource(PricingConstant.FEE_SOURCE_ENDO_PREMIUM);


		Map<String,Object> factors = root.getFactors();
		factors.put(PricingConstant.ENDORSEMENT_TYPE_FACTOR, bizObject.getEndorsementType().getId());
		factors.put(PricingConstant.ENDO_EFF_DATE,new Date(bizObject.getEffectiveDate().getTime()));

		//load policy log
		Long endoId = bizObject.getEndorsementId();
		Long policyId = bizObject.getPolicyId();	
		Policy policyLog = logService.loadLogPolicy(endoId, LogType.ISSUE_LOG.getId());
		factors.put(PricingConstant.ORIGINAL_POL_EFF_DATE, new Date(policyLog.getEffectiveDate().getTime()));
		factors.put(PricingConstant.ORIGINAL_POL_EXP_DATE, new Date(policyLog.getExpiredDate().getTime()));

		//load current policy
		Policy policy = policyService.loadPolicy(policyId);
		factors.put(PricingConstant.NEW_POL_EFF_DATE, new Date(policyLog.getEffectiveDate().getTime()));
		factors.put(PricingConstant.NEW_POL_EXP_DATE, new Date(policyLog.getExpiredDate().getTime()));

		//generate policy data pair

		Pair rootPair = new Pair(policyLog,policy);

		List<Pair<BaseModel>> insuredPairs = generalPair(policyLog.getInsureds(),policy.getInsureds());

		rootPair.getSubPairs().addAll(insuredPairs);

		for(Pair<BaseModel> pair : insuredPairs){
			Insured oldInsured = (Insured)pair.getOriginalObj();
			Insured newInsured = (Insured)pair.getNewObj();

			List<Pair<BaseModel>> coveragePairs = generalPair(oldInsured.getCoverages(),newInsured.getCoverages());

			pair.getSubPairs().addAll(coveragePairs);
		}
		//build endorsement rating model		
		List<Pair> subPairs = rootPair.getSubPairs();
		for(Pair pair : subPairs){
			Fee ifee = new Fee();
			if(pair.getNewObj() instanceof BaseModel){
				ifee.setRefBusinessObjUid(((BaseModel)pair.getNewObj()).getUuid());
				ifee.setRefBusinessObjName(((BaseModel)pair.getNewObj()).getClass().getSimpleName());
			}
			fee.getSubFees().add(ifee);

			PricingModel iModel = new PricingModel();
			iModel.setRefObject(ifee);
			iModel.setSource(PricingConstant.FEE_SOURCE_ENDO_PREMIUM);
			root.getSubRatingModels().add(iModel);

			List<Pair> subSubPairs = pair.getSubPairs();
			for(Pair subPair : subSubPairs){
				Fee cfee = new Fee();
				ifee.getSubFees().add(cfee);

				PricingModel cModel = new PricingModel();
				cModel.setRefObject(cfee);
				cModel.setSource(PricingConstant.FEE_SOURCE_ENDO_PREMIUM);
				cModel.setCalculator(calculator);
				iModel.getSubRatingModels().add(cModel);

				cModel.getFactors().putAll(iModel.getFactors());
				cModel.getFactors().putAll(root.getFactors());

				BaseModel oCoverage = (BaseModel)subPair.getOriginalObj();
				BaseModel nCoverage = (BaseModel)subPair.getNewObj();

				if(nCoverage instanceof BaseModel){
					ifee.setRefBusinessObjUid(nCoverage.getUuid());
					ifee.setRefBusinessObjName(nCoverage.getClass().getSimpleName());
				}

				if(oCoverage == null && nCoverage != null){
					cModel.getFactors().put(PricingConstant.ORIGINAL_FEE_ANP, BigDecimal.ZERO);

					if(nCoverage instanceof Coverage){
						if(LiabilityStatus.EFFECTIVE.getId() == ((Coverage)oCoverage).getStatus().getId()){
							cModel.getFactors().put(PricingConstant.NEW_FEE_ANP, getPremium(((Coverage)nCoverage).getFee().getItems(),PricingConstant.FEE_TYPE_ANP));
						}else{
							cModel.getFactors().put(PricingConstant.NEW_FEE_ANP, BigDecimal.ZERO);
						}
					}
				}else if(oCoverage != null && nCoverage != null){

					if(oCoverage instanceof Coverage){
						
						if(LiabilityStatus.EFFECTIVE.getId() == ((Coverage)oCoverage).getStatus().getId()){
							cModel.getFactors().put(PricingConstant.ORIGINAL_FEE_ANP, getPremium(((Coverage)oCoverage).getFee().getItems(),PricingConstant.FEE_TYPE_ANP));
						}else{
							cModel.getFactors().put(PricingConstant.ORIGINAL_FEE_ANP, BigDecimal.ZERO);
						}
					}

					if(nCoverage instanceof Coverage){
						
						if(LiabilityStatus.EFFECTIVE.getId() == ((Coverage)oCoverage).getStatus().getId()){
							cModel.getFactors().put(PricingConstant.NEW_FEE_ANP, getPremium(((Coverage)nCoverage).getFee().getItems(),PricingConstant.FEE_TYPE_ANP));
						}else{
							cModel.getFactors().put(PricingConstant.NEW_FEE_ANP, BigDecimal.ZERO);
						}
					}
				}
			}
		}

		return root;
	}

	private BigDecimal getPremium(List<FeeItem> fees,String feeType){
		for(FeeItem fee : fees){
			if(fee.getFeeType().equals(feeType) && fee.getSource() == PricingConstant.FEE_SOURCE_NEWBIZ_PREMIUM)
				return fee.getAmount();
		}

		return BigDecimal.ZERO;
	}

	private <T extends BaseModel> List<Pair<BaseModel>> generalPair(List<T> originals , List<T> newobjs){

		List<Pair<BaseModel>>  ps = new ArrayList<Pair<BaseModel>>();

		List<BaseModel> temp = new ArrayList<BaseModel>();
		temp.addAll(newobjs);

		for(BaseModel o : originals){

			for(BaseModel n : newobjs){
				if(o.getUuid().equals(n.getUuid())){
					Pair<BaseModel> p = new Pair<BaseModel>(o,n);
					ps.add(p);

					temp.remove(n);
				}
			}
		}
		for(BaseModel t : temp){
			Pair<BaseModel> p = new Pair<BaseModel>(null,t);
			ps.add(p);
		}
		return ps;	
	}


	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

}
