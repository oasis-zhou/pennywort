package insurance.cn.ds;

import insurance.cn.model.ChannelSpec;
import insurance.cn.model.CommissionSpec;


public interface ChannelService {

	public ChannelSpec findChannel(String channelId);
	
	public CommissionSpec findCommissionSpec(String channelId,String productId);
}
