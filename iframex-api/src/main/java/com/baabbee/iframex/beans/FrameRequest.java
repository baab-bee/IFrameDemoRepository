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
	
	@Column(name = "frame_request_type")
	private String type;
	
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
	@JoinColumn(name = "user_request_id")
	private UserRequest userRequest;
	
	@OneToOne
	private Frame frame;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
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
	public UserRequest getUserRequest() {
		return userRequest;
	}
	public void setUserRequest(UserRequest userRequest) {
		this.userRequest = userRequest;
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
}
