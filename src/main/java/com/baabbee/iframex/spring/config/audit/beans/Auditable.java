package com.baabbee.iframex.spring.config.audit.beans;

	import org.springframework.data.annotation.CreatedBy;
	import org.springframework.data.annotation.CreatedDate;
	import org.springframework.data.annotation.LastModifiedBy;
	import org.springframework.data.annotation.LastModifiedDate;
	import org.springframework.data.jpa.domain.support.AuditingEntityListener;

	import javax.persistence.Column;
	import javax.persistence.EntityListeners;
	import javax.persistence.MappedSuperclass;
	import java.util.Date;
	
	/*Extend this class for the audit columns to get the values..
	createdby and modifiedby can also updated from here if required*/

	@MappedSuperclass
	@EntityListeners(AuditingEntityListener.class)
	public class Auditable<U>
	{
		@CreatedDate
	    @Column(name = "created_date")
	    private Date createdDate;

	    public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		@LastModifiedDate
	    @Column(name = "last_modified_date")
	    private Date lastModifiedDate;
	    
	    public Date getLastModifiedDate() {
			return lastModifiedDate;
		}

		public void setLastModifiedDate(Date lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
		}
	}
