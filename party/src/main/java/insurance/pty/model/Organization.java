package insurance.pty.model;

import insurance.pty.model.enums.PartyCategory;

public class Organization extends Party {

	private String name;
	private Integer idType;
	private String idNumber;
	private String phone;
	private String email;
	
	public Organization(){
		this.setCategory(PartyCategory.ORGANIZATION);
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
	
}
