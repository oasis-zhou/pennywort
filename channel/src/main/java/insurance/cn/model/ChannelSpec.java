package insurance.cn.model;

import insurance.fd.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class ChannelSpec extends BaseModel {
	
	private String name;
	private String code;
	private String phone;
	private String mail;
	private String fax;
	private String description;
	private Boolean isOnline;
	private Boolean isOffline;
	private List<String> productAbility;
	private List<String> serviceAbility;
	
	private List<SalesAgreementSpec> agreements;
	private SalesIntegrationSpec integration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Boolean getIsOffline() {
		return isOffline;
	}
	public void setIsOffline(Boolean isOffline) {
		this.isOffline = isOffline;
	}
	public List<String> getProductAbility() {
		if(productAbility == null){
			productAbility = new ArrayList<String>();
		}
		return productAbility;
	}
	public void setProductAbility(List<String> productAbility) {
		this.productAbility = productAbility;
	}
	public List<String> getServiceAbility() {
		if(serviceAbility == null){
			serviceAbility = new ArrayList<String>();
		}
		return serviceAbility;
	}
	public void setServiceAbility(List<String> serviceAbility) {
		this.serviceAbility = serviceAbility;
	}
	public List<SalesAgreementSpec> getAgreements() {
		if(agreements == null){
			agreements = new ArrayList<SalesAgreementSpec>();
		}
		return agreements;
	}
	public void setAgreements(List<SalesAgreementSpec> agreements) {
		this.agreements = agreements;
	}
	public SalesIntegrationSpec getIntegration() {
		return integration;
	}
	public void setIntegration(SalesIntegrationSpec integration) {
		this.integration = integration;
	}
	
	
}
