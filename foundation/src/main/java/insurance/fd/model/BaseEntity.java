package insurance.fd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.google.common.base.Preconditions;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "creation_time", columnDefinition = "datetime(3)")
	private Date creationTime;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modification_time", columnDefinition = "datetime(3)")
	private Date modificationTime;
	
	@Column(name = "organization")
	private String organization;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		if(this.organization != null)
			Preconditions.checkNotNull(organization, "[FastFail]Organization cannot be set null");
		this.organization = organization;
	}


//	@PrePersist
//	protected void prePersist() {
//		this.creationTime = DateContext.getLocalTimeByCurrentUser();
//		this.modificationTime = DateContext.getLocalTimeByCurrentUser();
//		
//		AuthenticationFacade authFacade = ApplicationContextUtils.getBean(AuthenticationFacade.class);
//		if(authFacade!=null) {
//			if(authFacade.getAuthentication()!=null) {
//				this.createdBy = authFacade.getAuthentication().getName();
//				this.modifiedBy = authFacade.getAuthentication().getName();
//			} else {
//				this.createdBy = "_UNKNOWN";
//				this.modifiedBy = "_UNKNOWN";
//			}
//			if(this.company == null)
//				this.company = authFacade.getCompany();
//			if(this.country == null)
//				this.country = authFacade.getCountry();
//		}
//	}
//
//	@PreUpdate
//	protected void preUpdate() {
//		Preconditions.checkNotNull(country, "[FastFail]Country cannot be set null");
//		Preconditions.checkNotNull(company, "[FastFail]Company cannot be set null");
//		this.modificationTime = DateContext.getLocalTimeByCurrentUser();
//		
//		AuthenticationFacade authFacade = ApplicationContextUtils.getBean(AuthenticationFacade.class);
//		if(authFacade!=null && authFacade.getAuthentication()!=null) {
//			this.modifiedBy = authFacade.getAuthentication().getName();
//		} else {
//			this.modifiedBy = "_UNKNOWN";
//		}
//	}
}
