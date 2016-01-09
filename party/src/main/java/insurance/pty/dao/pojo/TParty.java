package insurance.pty.dao.pojo;

import insurance.fd.model.BaseEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_PARTY")
public class TParty extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4598511113828772178L;
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
	private Integer category;
	@Column
	private Integer gender;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private Date birthday;
	
	@OneToMany(mappedBy="party", cascade= CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)     
	private Set<TPartyRole> partyRoles = new HashSet<TPartyRole>();

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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<TPartyRole> getPartyRoles() {
		return partyRoles;
	}

	public void setPartyRoles(Set<TPartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}
	
	
}
