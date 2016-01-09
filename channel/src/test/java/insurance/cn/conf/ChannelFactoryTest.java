package insurance.cn.conf;


import insurance.AbstractTest;
import insurance.cn.model.ChannelSpec;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChannelFactoryTest extends AbstractTest{
	
	@Autowired
	private ChannelFactory channelFactory;
	
	@Test
	public void loadProduct(){
		String channelId = "TAOBAO";
		
		ChannelSpec channel = channelFactory.findChannel(channelId);
		
		Assert.assertEquals("TAOBAO", channel.getUuid());
		
		ChannelSpec channelSecond = channelFactory.findChannel(channelId);
		
		Assert.assertEquals("TAOBAO", channelSecond.getUuid());
	}

}
