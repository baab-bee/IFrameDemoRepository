package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.DonorRequest;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.repository.DonorRequestRepository;

@Service
@Transactional
public class DonorRequestService {
	@Autowired
	private DonorRequestRepository donRequestRepository;
	
	public List<DonorRequest> getAllDonorRequests() {
		List<DonorRequest> donRequests = new ArrayList<DonorRequest>();
		donRequestRepository.findAll().forEach(donRequests::add);
		return donRequests;
	}
	
	public DonorRequest getDonorRequest(Long id) throws EntityNotFoundException {
		DonorRequest donorReq = null;
		try {
			donorReq = donRequestRepository.findById(id).get();
			System.out.println("testing this object "+donorReq);
		} catch (Exception e) {
			if (donorReq == null)
				throw new EntityNotFoundException(DonorRequest.class, "id", id.toString());
		}
		return donorReq;
	}
	
	public void addDonorRequest(DonorRequest userRequest) {
		donRequestRepository.save(userRequest);	
	
	}

	public void addDonorRequests(Set<DonorRequest> userRequests) {
		donRequestRepository.saveAll(userRequests);		
	}

	public void updateDonorRequest(DonorRequest userRequest) {
		//userRequest.setId(id);
		donRequestRepository.save(userRequest);
	}
	
	public void deleteDonorRequest(Long id) {
		donRequestRepository.deleteById(id);
	}
	
	public DonorRequest find(Long id) {
		System.out.println("find method executed....");
		DonorRequest donreq= donRequestRepository.findById(id).get();
		System.out.println("Donor Object returned is "+donreq);
		return donreq;
    }
	
//	public List<DonorRequest> getByInitStatus(String status) {
//		List<DonorRequest> donrequest=donRequestRepository.findByStatus(status);
//		return donrequest;
//	}

	public List<DonorRequest> findByStatusIn(List<String> statuslist) {
		List<DonorRequest> donReq=donRequestRepository.findByStatusIn(statuslist);		
		return donReq;		
	}

	/*public void partialUpdateDonorRequests(String status, Long id) {
		 donRequestRepository.updateAllStatus(status,id);
	}*/

	public DonorRequest save(DonorRequest donorrequest) {
		return donRequestRepository.save(donorrequest);
	}

	/*public void save(DonorRequestStatusOnly partialUpdate, String id) {
		donRequestRepository.save(partialUpdate);
	}*/

	}
