package com.baabbee.iframex.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.baabbee.iframex.spring.config.audit.beans.Auditable;

@Entity
@Table(name = "don_request")
public class DonorRequest extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "don_request_id")
	private Long id;
	
	@Column(name = "envelope_size")
	private int envelopeSize;
	
	@Column(name = "don_request_remarks")
	private String remarks;
	
	@Column(name = "don_request_status")
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)//unidirectional
	@JoinColumn(name = "user_id")
	private User user;
	
	public DonorRequest() {
		
	}
	
	public DonorRequest(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getEnvelopeSize() {
		return envelopeSize;
	}
	public void setEnvelopeSize(int envelopeSize) {
		this.envelopeSize = envelopeSize;
	}
	
	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", status=" + status
				+ ", toString()=" + super.toString() + "]";
	}
	

}
