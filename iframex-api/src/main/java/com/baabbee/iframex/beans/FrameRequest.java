package com.baabbee.iframex.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frame_request")
public class FrameRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "frame_request_id")
	private Long id;
	
	@Column(name = "frame_request_size")
	private String size;
	
	@Column(name = "frame_request_color")
	private String color;
	
	@Column(name = "frame_request_material")
	private String material;
	
	@Column(name = "frame_request_status")
	private String status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@ManyToOne
	@JoinColumn(name = "benef_request_id")
	private BeneficiaryRequest benefRequest;
	
	@OneToOne
	private Frame frame;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public BeneficiaryRequest getUserRequest() {
		return benefRequest;
	}
	public void setUserRequest(BeneficiaryRequest userRequest) {
		this.benefRequest = userRequest;
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	

}
