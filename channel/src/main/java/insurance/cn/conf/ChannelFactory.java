package insurance.cn.conf;

import insurance.cn.model.ChannelSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ChannelFactory {
	private static Logger logger = LoggerFactory.getLogger(ChannelFactory.class);
	
	@Autowired
	private ChannelConfiguration configuration;

	@Cacheable(value="channel")
	public ChannelSpec findChannel(String channelId)  {
		try{
			logger.debug("Load channel " + channelId +" first.\n");
			return configuration.getChannel(channelId);
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}
	
	@CacheEvict(value="channel",allEntries=true)// clear cache
	public void refreshCache() { 
	} 

}