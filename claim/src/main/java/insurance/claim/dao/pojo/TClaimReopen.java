package insurance.claim.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import insurance.fd.model.BaseEntity;
@Entity
@Table(name="T_CLM_REOPEN")
public class TClaimReopen extends BaseEntity  {
	private static final Long serialVersionUID=1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	@NotNull
	private Long claimId;
	@Column
	private String reopenCause;
	@Column(length=3000)
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClaimId() {
		return claimId;
	}
	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}
	public String getReopenCause() {
		return reopenCause;
	}
	public void setReopenCause(String reopenCause) {
		this.reopenCause = reopenCause;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
