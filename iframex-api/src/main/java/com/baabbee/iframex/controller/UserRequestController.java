package com.baabbee.iframex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.beans.UserRequest;
import com.baabbee.iframex.service.UserRequestService;

@RestController
public class UserRequestController {
	
	@Autowired
	private UserRequestService userRequestService;
	
	@RequestMapping("/userRequests")
	public List<UserRequest> getAllUserRequests() {
		return userRequestService.getAllUserRequests();
	}
	
	@RequestMapping("/userRequests/{id}")
	public UserRequest getUserRequest(@PathVariable("id") Long id) {
		return userRequestService.getUserRequest(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/userRequests")
	public void addUserRequest(@RequestBody UserRequest userRequest) {
		userRequestService.addUserRequest(userRequest);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/userRequests/{id}")
	public void updateUserRequest(@RequestBody UserRequest userRequest, @PathVariable Long id) {
		userRequestService.updateUserRequest(id, userRequest);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/userRequests/{id}")
	public void deleteUserRequest(@PathVariable Long id) {
		userRequestService.deleteUserRequest(id);
	}

}
