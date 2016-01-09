package insurance.bcp.dao.pojo;

import insurance.fd.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class TGLFee extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1021924373710427069L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private Integer bizTransaction;
	@Column
	private String refBizNumber;
	@Column
	private Integer currency;
	@Lob
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBizTransaction() {
		return bizTransaction;
	}
	public void setBizTransaction(Integer bizTransaction) {
		this.bizTransaction = bizTransaction;
	}
	public String getRefBizNumber() {
		return refBizNumber;
	}
	public void setRefBizNumber(String refBizNumber) {
		this.refBizNumber = refBizNumber;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
