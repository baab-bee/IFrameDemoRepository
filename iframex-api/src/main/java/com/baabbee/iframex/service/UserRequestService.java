package com.baabbee.iframex.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.beans.UserRequest;
import com.baabbee.iframex.repository.UserRequestRepository;

@Service
public class UserRequestService {
	@Autowired
	private UserRequestRepository userRequestRepository;
	
	public List<UserRequest> getAllUserRequests() {
		List<UserRequest> userRequests = new ArrayList<UserRequest>();
		userRequestRepository.findAll().forEach(userRequests::add);
		return userRequests;
	}
	
	public UserRequest getUserRequest(Long id) {
		return userRequestRepository.findById(id).get();
	}
	
	public void addUserRequest(UserRequest userRequest) {
		//Set the last modified date
		userRequest.setLastModifiedDate(userRequest.getCreatedDate());
		//Set the status
		if (userRequest.getUserRequestType().equalsIgnoreCase("D")) {
			userRequest.setStatus("DON_INITIATED");			
		} else {
			userRequest.setStatus("BEN_INITIATED");
		}
		//Set envelope size
		userRequest.setEnvelopeSize();
		userRequestRepository.save(userRequest);
	}

	public void addUserRequests(Set<UserRequest> userRequests) {
		userRequestRepository.saveAll(userRequests);		
	}

	public void updateUserRequest(Long id, UserRequest userRequest) {
		userRequestRepository.save(userRequest);
	}
	
	public void deleteUserRequest(Long id) {
		userRequestRepository.deleteById(id);
	}

	public enum UserRequestStatus {
		DON_INITIATED,
		DON_PROCESSED,
		DON_PREPAID_SENT,
		DON_RECIEVED,
		DON_VALIDATED,
		DON_INV,
		DON_COMPLETE,
		BEN_INITIATED,
		BEN_PROCESSED,
		BEN_PREPAID_SENT,
		BEN_RECIEVED,
		BEN_VALIDATED,
		BEN_INV,
		BEN_COMPLETE
	}
}
