package com.baabbee.iframex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.DonorRequest;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.service.DonorRequestService;
import com.baabbee.iframex.service.FrameRequestService;
import com.baabbee.iframex.spring.config.patch.json.Patch;
import com.baabbee.iframex.spring.config.patch.json.PatchRequestBody;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FrameRequestController {
	
	@Autowired
	private FrameRequestService frameRequestService;
	
	@RequestMapping("/frameRequests")
	public List<FrameRequest> getAllFrameRequests() {
		return frameRequestService.getAllFrameRequests();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/frameRequests/{id}")
	public FrameRequest getFrameRequest(@PathVariable("id") Long id) throws EntityNotFoundException {
		return frameRequestService.getFrameRequest(id);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/frameRequests/search")
	public List<FrameRequest> getFrameRequestByStatus(@RequestParam("status") String status) {
		return frameRequestService.getFrameRequestByStatus(status);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/frameRequests")
	public void addFrameRequest(@RequestBody FrameRequest frameRequest) {
		frameRequestService.addFrameRequest(frameRequest);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/frameRequests/{id}")
	public void updateFrameRequest(@RequestBody FrameRequest frameRequest, @PathVariable Long id) {
		frameRequest.setId(id);
		frameRequestService.updateFrameRequest(id, frameRequest);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/frameRequests/{id}")
	public void deleteFrameRequest(@PathVariable Long id) {
		frameRequestService.deleteFrameRequest(id);
	}
	
	@RequestMapping(value = "/frameRequests/{id}", method = RequestMethod.PATCH,produces = MediaType.APPLICATION_JSON_VALUE)
    @Patch(service = FrameRequestService.class, id = Long.class)
    public FrameRequest patch(@PathVariable List<Long> id,
                       @PatchRequestBody FrameRequest donorrequest) {
		System.out.println(donorrequest);
		frameRequestService.save(donorrequest);
		return donorrequest;
		
    }
}
