package insurance.pa.newbiz.dao.pojo;

import insurance.fd.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_CUSTOMER_INDEX")
public class TCustomerIndex extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4560095250655852173L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private Integer idType;
	@Column
	private String idNumber;
	@Column
	private String regNumber;
	@Column
	private Long partyId;
	@Column
	private Integer partyRole;
	@Column
	private Integer partyCategory;
	
	@ManyToOne
	@JoinColumn(name = "policyId")
	@NotNull
	private TPolicyIndex policy;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Integer getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(Integer partyRole) {
		this.partyRole = partyRole;
	}

	public Integer getPartyCategory() {
		return partyCategory;
	}

	public void setPartyCategory(Integer partyCategory) {
		this.partyCategory = partyCategory;
	}

	public TPolicyIndex getPolicy() {
		return policy;
	}

	public void setPolicy(TPolicyIndex policy) {
		this.policy = policy;
	}
	
	

}
