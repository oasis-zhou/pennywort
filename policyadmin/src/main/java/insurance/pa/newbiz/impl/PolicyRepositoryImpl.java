package insurance.pa.newbiz.impl;

import insurance.fd.conf.SystemConfig;
import insurance.fd.utils.JsonHelper;
import insurance.pa.model.Policy;
import insurance.pa.newbiz.PolicyIndexFactory;
import insurance.pa.newbiz.PolicyRepository;
import insurance.pa.newbiz.dao.PolicyDao;
import insurance.pa.newbiz.dao.PolicyIndexDao;
import insurance.pa.newbiz.dao.QuotationDao;
import insurance.pa.newbiz.dao.QuotationIndexDao;
import insurance.pa.newbiz.dao.pojo.TPolicy;
import insurance.pa.newbiz.dao.pojo.TPolicyIndex;
import insurance.pa.newbiz.dao.pojo.TQuotation;
import insurance.pa.newbiz.dao.pojo.TQuotationIndex;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

@Repository
public class PolicyRepositoryImpl implements PolicyRepository {

	private static Logger logger = LoggerFactory.getLogger(PolicyRepositoryImpl.class);

	@Autowired
	private SystemConfig sysConf;
	@Autowired
	private PolicyDao policyDao;
	@Autowired
	private QuotationDao quotationDao;
	@Autowired
	private PolicyIndexDao policyIndexDao;
	@Autowired
	private QuotationIndexDao quotationIndexDao;
	@Autowired
	private PolicyIndexFactory indexFactory;
	@Autowired
	private JsonHelper jsonHelper;

	@Autowired
	private RedisTemplate<String, String> template;

	private ValueOperations<String, String> operations;
	private boolean isNoSql;

	@PostConstruct
	public void init() {
		//这里设置value的序列化方式为JacksonJsonRedisSerializer 
		// emplate.setValueSerializer(new Jackson2JsonRedisSerializer<Policy>(Policy.class));
		// explicitly enable transaction support
		template.setEnableTransactionSupport(true);
		operations = template.opsForValue();

		if(sysConf.env().getProperty("database.nosql") != null){
			String conf = sysConf.env().getProperty("database.nosql");

			isNoSql = Boolean.parseBoolean(conf);

		}
	}

	public void set(String key, String value) {
		operations.set(key, value);
	}

	public String get(String key) {
		return operations.get(key);
	}

	@Override
	public <T extends Policy> T saveQuotation(T policy) {
		if(this.isNoSql){
			String key = policy.getUuid();
			String content = jsonHelper.toJSON(policy);
			this.set(key,content);
		}else{
			TQuotation quotation = null;
			if(policy.getQuotationId() != null){
				quotation = quotationDao.findOne(policy.getQuotationId());
			}else{
				quotation = new TQuotation();
			}
			quotation.setUuid(policy.getUuid());
			quotation.setProductId(policy.getProductId());
			quotation.setChannelId(policy.getChannelId());
			quotation.setBusinessOrgan(policy.getBusinessOrgan());
			quotation.setVersion(policy.getVersion());

			String content = jsonHelper.toJSON(policy);
			quotation.setContent(content);

			TQuotation p = quotationDao.save(quotation);

			policy.setQuotationId(p.getId());
		}

		return policy;
	}

	@Override
	public Policy loadQuotation(Long quotationId) {
		Policy quotation = null;
		TQuotation po = quotationDao.findOne(quotationId);

		if(po != null){
			quotation = jsonHelper.fromJSON(po.getContent(),Policy.class);
		}

		quotation.setQuotationId(quotationId);

		return quotation;
	}

	@Override
	public <T extends Policy> T savePolicy(T policy) {
		if(this.isNoSql){
			String key = policy.getUuid();
			String content = jsonHelper.toJSON(policy);
			this.set(key,content);
		}else{
			TPolicy policyPo = null;
			if(policy.getPolicyId() != null){
				policyPo = policyDao.findOne(policy.getPolicyId());
			}else{
				policyPo = new TPolicy();
			}
			policyPo.setUuid(policy.getUuid());
			policyPo.setProductId(policy.getProductId());
			policyPo.setChannelId(policy.getChannelId());
			policyPo.setBusinessOrgan(policy.getBusinessOrgan());
			policyPo.setVersion(policy.getVersion());

			String content = jsonHelper.toJSON(policy);
			policyPo.setContent(content);

			TPolicy po = policyDao.save(policyPo);

			policy.setPolicyId(po.getId());
		}

		return policy;
	}

	@Override
	public Policy loadPolicy(Long policyId) {
		Policy policy = null;
		TPolicy po = policyDao.findOne(policyId);

		if(po != null){
			policy = jsonHelper.fromJSON(po.getContent(), Policy.class);
		}

		policy.setPolicyId(policyId);

		return policy;
	}

	@Override
	public <T extends Policy> void saveQuotationIndex(T policy) {	
		if(policy.getQuotationId() != null){
			TQuotationIndex po = quotationIndexDao.findQuotationIndexByQuotationId(policy.getQuotationId());
			if(po == null){
				po = new TQuotationIndex();
			}	

			indexFactory.buildQuotationIndex(po,policy);		
			quotationIndexDao.save(po);
		}
	}

	@Override
	public <T extends Policy> void savePolicyIndex(T policy) {
		if(policy.getPolicyId() != null){
			TPolicyIndex po = policyIndexDao.findPolicyIndexByPolicyId(policy.getPolicyId());
			if(po == null){
				po = new TPolicyIndex();
			}	

			indexFactory.buildPolicyIndex(po,policy);
			policyIndexDao.save(po);
		}
	}

}
