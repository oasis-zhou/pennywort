package insurance.pa.endo.dao.pojo;

import insurance.fd.model.BaseEntity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "T_POLICY_LOG")
public class TPolicyLog extends BaseEntity {

/**
	 * 
	 */
	private static final long serialVersionUID = 2245234430640901613L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@Column
	private Long endoId;
	
	@Column
	private Integer logType;
	
	@Column
	private Long policyId;
	
	@Column
	private String uuid;
	@Column
	private String productId;
	@Column
	private Long channelId;
	@Column
	private String businessOrgan;
	@Column
	private String version;
	@Lob
	@Column(length = 10000)
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEndoId() {
		return endoId;
	}
	public void setEndoId(Long endoId) {
		this.endoId = endoId;
	}
	public Integer getLogType() {
		return logType;
	}
	public void setLogType(Integer logType) {
		this.logType = logType;
	}
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getBusinessOrgan() {
		return businessOrgan;
	}
	public void setBusinessOrgan(String businessOrgan) {
		this.businessOrgan = businessOrgan;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	


}
