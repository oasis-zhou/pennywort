package insurance.cn.conf;

import insurance.cn.model.ChannelSpec;
import insurance.cn.model.CommissionSpec;
import insurance.cn.model.SalesAgreementSpec;
import insurance.cn.model.SalesIntegrationSpec;
import insurance.cn.model.SalesSettlementSpec;
import insurance.fd.conf.SystemConfig;
import insurance.fd.context.AppContext;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@SuppressWarnings("serial")
@Component
public class ChannelConfiguration implements Serializable {

	@Autowired
	private SystemConfig sysConf;

	private static final String CONFIG_FILE_PATH = "classpath*:channel-*.xml";

	private Map<String, ChannelSpec> channelConfigMap = new HashMap<String, ChannelSpec>();

	public ChannelSpec getChannel(String channelId) throws Exception {
		ChannelSpec channel = (ChannelSpec) channelConfigMap.get(channelId);
		if (channel == null) {
			//load product configuration info
			load();

			channel = (ChannelSpec) channelConfigMap.get(channelId);	
			if( channel == null)
				throw new RuntimeException("The channel (id=" + channelId + ") is not found!");
		}
		return channel;
	}

	public void load() throws Exception {
		channelConfigMap.clear();

		SAXReader reader = new SAXReader();
		
		Resource[] resfiles = AppContext.getApplicationContext().getResources(CONFIG_FILE_PATH);

		for (Resource resfile : resfiles) {
			InputStream is = resfile.getInputStream();
			Document document = reader.read(new InputStreamReader(is));
			Element root = document.getRootElement();
			ChannelSpec channel = loadChannelConfig(root);

			channelConfigMap.put(channel.getUuid(),channel);
		}
	}

	protected ChannelSpec loadChannelConfig(Element root) throws Exception{

		SimpleDateFormat dateFormat = sysConf.getSysDateFormat();
		//product info
		ChannelSpec channel = new ChannelSpec();
		Element channelElement = root;
		channel.setUuid(channelElement.attributeValue("uuid"));
		channel.setCode(channelElement.attributeValue("code"));
		channel.setName(channelElement.attributeValue("name"));


		channel.setDescription(channelElement.elementText("desc"));
		channel.setPhone(channelElement.elementText("phone"));
		channel.setFax(channelElement.elementText("fax"));
		channel.setMail(channelElement.elementText("mail"));

		Element onlineOffline = channelElement.element("onlie-offline");
		if(onlineOffline.attributeValue("online") != null)
			channel.setIsOnline(Boolean.parseBoolean(onlineOffline.attributeValue("online")));

		if(onlineOffline.attributeValue("offline") != null)
			channel.setIsOffline(Boolean.parseBoolean(onlineOffline.attributeValue("offline")));

		String productLineStr = channelElement.elementText("product-ability");
		if(productLineStr != null){
			String[] productLines = productLineStr.split(",");
			List<String> productLineList = Arrays.asList(productLines);
			channel.getProductAbility().addAll(productLineList);
		}

		String serviceStr = channelElement.elementText("service-ability");
		if(serviceStr != null){
			String[] services = serviceStr.split(",");
			List<String> serviceList = Arrays.asList(services);
			channel.getServiceAbility().addAll(serviceList);
		}

		//integration info
		Element integration = channelElement.element("integration");
		SalesIntegrationSpec inte = new SalesIntegrationSpec();
		channel.setIntegration(inte);

		//product coverage info
		Element agreementsElement = channelElement.element("agreements");	
		if(agreementsElement != null){
			List<Element> agreementElements = agreementsElement.elements();
			for (Element agreementElement : agreementElements) {
				SalesAgreementSpec agreement = new SalesAgreementSpec();
				agreement.setUuid(agreementElement.attributeValue("uuid"));
				agreement.setName(agreementElement.attributeValue("name"));

				if(agreementElement.elementText("effDate") != null){
					agreement.setEffectiveDate(dateFormat.parse(agreementElement.elementText("effDate")));
				}
				if(agreementElement.elementText("expDate") != null){
					agreement.setExpiredDate(dateFormat.parse(agreementElement.elementText("expDate")));
				}

				agreement.setDescription(agreementElement.elementText("desc"));
				agreement.setProductId(agreementElement.elementText("product"));


				Element settlementElement = agreementElement.element("settlement");
				SalesSettlementSpec setl = new SalesSettlementSpec();
				agreement.setSettlement(setl);

				Element commissionElement = agreementElement.element("commission");
				CommissionSpec comm = new CommissionSpec();
				comm.setCalculationType(commissionElement.attributeValue("calType"));
				if(commissionElement.attributeValue("realTime") != null)
					comm.setIsRealTime(Boolean.parseBoolean(commissionElement.attributeValue("realTime")));
				if(commissionElement.getText() != null)
					comm.setValue(new BigDecimal(commissionElement.getText()));
				agreement.setCommission(comm);


				String sStr = agreementElement.elementText("service");
				if(sStr != null){
					String[] ss = sStr.split(",");
					List<String> sList = Arrays.asList(ss);
					agreement.getServices().addAll(sList);
				}

				channel.getAgreements().add(agreement);
			}
		}
		return channel;
	}

}
