package com.baabbee.iframex.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.beans.BeneficiaryRequest;
import com.baabbee.iframex.service.BeneficiaryRequestService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficiaryRequestController {

	@Autowired
	private BeneficiaryRequestService benRequestService;

	@RequestMapping("/beneficiaryRequests")
	public List<BeneficiaryRequest> getAllUserRequests() {
		return benRequestService.getAllBeneficiaryRequests();
	}

	@RequestMapping("/beneficiaryRequests/{id}")
	public BeneficiaryRequest getUserRequest(@PathVariable("id") Long id) {
		return benRequestService.getBeneficiaryRequest(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/beneficiaryRequests")
	public void addUserRequest(@RequestBody BeneficiaryRequest userRequest) {
		benRequestService.addBeneficiaryRequest(userRequest);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/beneficiaryRequests/{id}")
	public void updateUserRequest(@RequestBody BeneficiaryRequest userRequest, @PathVariable Long id) {
		benRequestService.updateBeneficiaryRequest(id, userRequest);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/beneficiaryRequests/{id}")
	public void deleteUserRequest(@PathVariable Long id) {
		benRequestService.deleteBeneficiaryRequest(id);

	}

	@RequestMapping("/beneficiaryRequests/{status}")
	public List<BeneficiaryRequest> getByInitStatus(@PathVariable String status) {
		List<BeneficiaryRequest> userrequest = benRequestService.getByInitStatus(status);
		return userrequest;
	}

	@RequestMapping("/beneficiaryRequests/{status1}/{status2}")
	// pass 'prepaid sent' and 'don_received' statuses for the 'receive and validate
	// button'
	public List<BeneficiaryRequest> getValidationRequests(@PathVariable String status1, @PathVariable String status2) {
		List<String> statuslist = new ArrayList<String>();
		Collections.addAll(statuslist, status1, status2);
		List<BeneficiaryRequest> userrequest = benRequestService.findByStatusIn(statuslist);
		return userrequest;
	}
}
