package com.baabbee.iframex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.DonorRequest;
import com.baabbee.iframex.service.DonorRequestService;
import com.baabbee.iframex.spring.config.patch.json.Patch;
import com.baabbee.iframex.spring.config.patch.json.PatchRequestBody;

@RestController
public class DonorRequestController {

	@Autowired
	private DonorRequestService donRequestService;

	@RequestMapping(method = RequestMethod.GET,value="/donorRequests")
	public List<DonorRequest> getAllUserRequests() {
		System.out.println("in all get");
		return donRequestService.getAllDonorRequests();
	}

	@RequestMapping(method = RequestMethod.GET,value="/donorRequests/{id}")
	public DonorRequest getUserRequest(@PathVariable("id") Long id) throws EntityNotFoundException {
		System.out.println("in get");
		return donRequestService.getDonorRequest(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/donorRequests")
	public void addUserRequest(@RequestBody DonorRequest userRequest) {
		System.out.println("in post");
		donRequestService.addDonorRequest(userRequest);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/donorRequests/{id}")
	public void updateUserRequest(@RequestBody DonorRequest userRequest, @PathVariable Long id) {
		System.out.println("in put");
		userRequest.setId(id);
		donRequestService.updateDonorRequest(userRequest);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/donorRequests/{id}")
	public void deleteUserRequest(@PathVariable Long id) {
		System.out.println("in del");
		donRequestService.deleteDonorRequest(id);

	}

//	@RequestMapping("/donorRequests/{status}")
//	public List<DonorRequest> getByInitStatus(@PathVariable String status) {
//		List<DonorRequest> userrequest = donRequestService.getByInitStatus(status);
//		return userrequest;
//	}

	@RequestMapping(value= "/donorRequests/search", method=RequestMethod.GET)
	// pass 'prepaid sent' and 'don_received' statuses for the 'receive and validate
	// button'
	public List<DonorRequest> getValidationRequests(@RequestParam("status") List<String> status) {
		System.out.println("in search get");
		List<DonorRequest> userrequest = donRequestService.findByStatusIn(status);
		return userrequest;
	}
	
	//http://localhost:8080/donorRequests/19
	@RequestMapping(value = "/donorRequests/{id}", method = RequestMethod.PATCH,produces = MediaType.APPLICATION_JSON_VALUE)
    @Patch(service = DonorRequestService.class, id = Long.class)
    public DonorRequest patch(@PathVariable List<Long> id,
                       @PatchRequestBody DonorRequest donorrequest) {
		System.out.println(donorrequest);
        donRequestService.save(donorrequest);
		return donorrequest;
		
    }

}
