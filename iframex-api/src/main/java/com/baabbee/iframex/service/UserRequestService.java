package com.baabbee.iframex.service;

import java.util.ArrayList;
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

	}
