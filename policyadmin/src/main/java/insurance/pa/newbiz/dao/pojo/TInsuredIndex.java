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
@Table(name = "T_INSURED_INDEX")
public class TInsuredIndex extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355007302702070194L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private String name;
	
	@Column
	private String field01;
	@Column
	private String field02;
	@Column
	private String field03;
	@Column
	private String field04;
	@Column
	private String field05;
	
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

	public String getField01() {
		return field01;
	}

	public void setField01(String field01) {
		this.field01 = field01;
	}

	public String getField02() {
		return field02;
	}

	public void setField02(String field02) {
		this.field02 = field02;
	}

	public String getField03() {
		return field03;
	}

	public void setField03(String field03) {
		this.field03 = field03;
	}

	public String getField04() {
		return field04;
	}

	public void setField04(String field04) {
		this.field04 = field04;
	}

	public String getField05() {
		return field05;
	}

	public void setField05(String field05) {
		this.field05 = field05;
	}

	public TPolicyIndex getPolicy() {
		return policy;
	}

	public void setPolicy(TPolicyIndex policy) {
		this.policy = policy;
	}
	
	

}
