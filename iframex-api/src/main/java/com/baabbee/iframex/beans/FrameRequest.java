package com.baabbee.iframex.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.baabbee.iframex.spring.config.audit.beans.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "frame_request")
public class FrameRequest extends Auditable<String> {
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
	
	@Column(name="gender")
	private String gender;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="FRAMEREQUEST_FRAME", 
	joinColumns = @JoinColumn(name="FRAME_REQUEST_ID"),
	inverseJoinColumns = @JoinColumn(name="FRAME_ID"))
	private Frame frame;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "benrequestid", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private BeneficiaryRequest benRequest;
	 
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
	 @JsonIgnore
	public BeneficiaryRequest getUserRequest() {
		return benRequest;
	}
	 @JsonIgnore
	public void setUserRequest(BeneficiaryRequest userRequest) {
		this.benRequest = userRequest;
	}
	
	 public Long getBeneficiaryRequest_id(){
	        return benRequest.getId();
	 }
	 
	 public String getBeneficiary_name() {
		 return benRequest.getUser().getName();
	 }
	 
	 public String getBeneficary_address() {
		 Address address = benRequest.getUser().getAddress();
		 return address.getAddressLine1() +  " " + address.getCity()+ " "+address.getState() + " " +address.getZipcode() + " "  +address .getCountry();
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
	
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "FrameRequest [id=" + id + ", size=" + size + ", color=" + color + ", material=" + material + ", status="
				+ status + ", gender="
				+ gender + ", frame=" + frame + "]";
	}

}
