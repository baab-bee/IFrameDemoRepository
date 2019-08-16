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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.baabbee.iframex.spring.config.audit.beans.Auditable;

@Entity
@Table(name = "frame")
public class Frame extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "frame_id")
	private Long id;
	
	@Column(name = "frame_name")
	private String name;
	
	@Column(name = "frame_size")
	private String size;
	
	@Column(name = "frame_color")
	private String color;
	
	@Column(name = "frame_material")
	private String material;
	
	@Column(name = "frame_status")
	private String status;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="remarks")
	private String remarks;
	
	@ManyToOne
	@JoinColumn(name = "don_request_id")
	private DonorRequest donorRequest;
	
	/*@OneToOne(mappedBy="FrameRequest")
	private Frame frame;*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Frame [id=" + id + ", name=" + name + ", size=" + size + ", color=" + color + ", material=" + material
				+ ", status=" + status + ", imageUrl=" + imageUrl + ", gender=" + gender + ", remarks=" + remarks
				+ ", donorRequest=" + donorRequest + "]";
	}
	

}
