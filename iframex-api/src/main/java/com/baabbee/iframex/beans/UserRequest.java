package com.baabbee.iframex.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_request")
public class UserRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_request_id")
	private Long id;
	
	@Column(name = "user_request_type")
	private String userRequestType;;
	
	@Column(name = "total_ord_qty")
	private int totalOrderedQty;
	
	@Column(name = "total_fulfilled_qty")
	private int totalFulfilledQty;
	
	@Column(name = "envelope_size")
	private String envelopeSize;
	
	@Column(name = "user_request_remarks")
	private String remarks;
	
	@Column(name = "user_request_status")
	private String status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "userRequest", cascade = CascadeType.ALL)
	private List<FrameRequest> frameRequests;
	
	
	
	public UserRequest() {
		
	}
	public UserRequest(Long id, int totalOrderedQty, String status) {
		super();
		this.id = id;
		this.totalOrderedQty = totalOrderedQty;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserRequestType() {
		return userRequestType;
	}
	public void setUserRequestType(String userRequestType) {
		this.userRequestType = userRequestType;
	}
	public int getTotalOrderedQty() {
		return totalOrderedQty;
	}
	public void setTotalOrderedQty(int totalOrderedQty) {
		this.totalOrderedQty = totalOrderedQty;
	}
	public int getTotalFulfilledQty() {
		return totalFulfilledQty;
	}
	public void setTotalFulfilledQty(int totalFulfilledQty) {
		this.totalFulfilledQty = totalFulfilledQty;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<FrameRequest> getFrameRequests() {
		return frameRequests;
	}
	public void setFrameRequests(List<FrameRequest> frameRequests) {
		this.frameRequests = frameRequests;
	}
	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", userRequestType=" + userRequestType + ", totalOrderedQty=" + totalOrderedQty 
				+ ", totalFulfilledQty=" + totalFulfilledQty + ", status=" + status + ", frameRequests=" + frameRequests
				+ ", toString()=" + super.toString() + "]";
	}
	

}
