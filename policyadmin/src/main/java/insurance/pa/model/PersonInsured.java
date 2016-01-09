package insurance.pa.model;

import java.util.Date;

/**
 * @author zheng.zhou
 * @version 1.0
 * @created 2015
 */
public abstract class PersonInsured extends Insured {

	private PersonName name;
	private Integer idType;
	private String idNumber;
	private String gender;
	private Date birthday;
	private Integer occupation;
	private String fullAddress;
	

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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getOccupation() {
		return occupation;
	}
	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	

}