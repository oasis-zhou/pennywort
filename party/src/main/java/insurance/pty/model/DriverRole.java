package insurance.pty.model;

import java.util.Date;


public class DriverRole extends Person{

	private PartyRole partyRole = PartyRole.DRIVER;
	private Integer drivingAge;
	private Integer driverRole;
	private Date licenseRegistrationDate;
	
	
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}
	public Integer getDrivingAge() {
		return drivingAge;
	}
	public void setDrivingAge(Integer drivingAge) {
		this.drivingAge = drivingAge;
	}
	public Integer getDriverRole() {
		return driverRole;
	}
	public void setDriverRole(Integer driverRole) {
		this.driverRole = driverRole;
	}
	public Date getLicenseRegistrationDate() {
		return licenseRegistrationDate;
	}
	public void setLicenseRegistrationDate(Date licenseRegistrationDate) {
		this.licenseRegistrationDate = licenseRegistrationDate;
	}
	
	
}
