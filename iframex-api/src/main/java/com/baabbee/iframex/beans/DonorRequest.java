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
		
	@Column(name="user_id")
	private Long user_id;

	/*@ManyToOne(cascade = CascadeType.ALL)//unidirectional
	@JoinColumn(name = "user_id")*/
	//private User user;

//	@OneToMany(mappedBy = "userRequest", cascade = CascadeType.ALL)
//	private List<FrameRequest> frameRequests;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	@OneToMany(mappedBy = "donorRequest", cascade = CascadeType.ALL)
	private List<Frame> frame;	
	
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

	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public List<Frame> getFrame() {
		return frame;
	}
	public void setFrame(List<Frame> frame) {
		this.frame = frame;
	}
	
	public int getEnvelopeSize() {
		return envelopeSize;
	}
	public void setEnvelopeSize(int envelopeSize) {
		this.envelopeSize = envelopeSize;
	}
	
	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", status=" + status + ", frame=" + frame
				+ ", toString()=" + super.toString() + "]";
	}
	

}
