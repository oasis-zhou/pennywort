package insurance.cn.ds.impl;

import insurance.cn.conf.ChannelFactory;
import insurance.cn.ds.ChannelService;
import insurance.cn.model.ChannelSpec;
import insurance.cn.model.CommissionSpec;
import insurance.cn.model.SalesAgreementSpec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelFactory channelFactory;
	
	@Override
	public ChannelSpec findChannel(String channelId){
		return channelFactory.findChannel(channelId);
	}
	
	@Override
	public CommissionSpec findCommissionSpec(String channelId,String productId) {
		ChannelSpec channel = channelFactory.findChannel(channelId);
		CommissionSpec comm = null;
		List<SalesAgreementSpec> agreements = channel.getAgreements();
		for(SalesAgreementSpec agreement : agreements){
			if(agreement.getProductId().equals(productId)){
				comm = agreement.getCommission();
			}
		}
		
		return comm;
	}

}
