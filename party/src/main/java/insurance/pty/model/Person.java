package insurance.pty.model;

import insurance.pty.model.enums.Gender;
import insurance.pty.model.enums.PartyCategory;

import java.util.Date;

public class Person extends Party {
	
	private PersonName name;
	private Integer idType;
	private String idNumber;
	private Gender gender;
	private Date birthday;
	private String phone;
	private String email;
	
	public Person(){
		this.setCategory(PartyCategory.PERSON);
	}
	
	public PersonName getName() {
		return name;
	}
	public void setName(PersonName name) {
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
