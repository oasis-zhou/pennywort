package insurance.bcp.dao.pojo;

import insurance.fd.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class TPayment extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1584068464560845865L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private String transNumber;
	@Column
	private Date transDate;
	@Column
	private BigDecimal amount;
	@Column
	private String payeeName;
	@Lob
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTransNumber() {
		return transNumber;
	}
	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
