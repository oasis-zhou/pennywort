package insurance.pty.dao.pojo;

import insurance.fd.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_PARTY_ROLE")
public class TPartyRole extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5460852457610563003L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column
	private Integer partyRole;
	@Lob
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "partyId")
	@NotNull
	private TParty party;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(Integer partyRole) {
		this.partyRole = partyRole;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TParty getParty() {
		return party;
	}

	public void setParty(TParty party) {
		this.party = party;
	}


	
}
