package insurance.pa.newbiz.dao.pojo;

import insurance.fd.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "T_POLICY")
public class TPolicy extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1543850843781156520L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private String uuid;
	@Column
	private String productId;
	@Column
	private String channelId;
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
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
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
