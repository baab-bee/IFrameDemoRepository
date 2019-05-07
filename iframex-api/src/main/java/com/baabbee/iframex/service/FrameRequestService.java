package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.repository.FrameRequestRepository;

@Service
public class FrameRequestService {
	@Autowired
	private FrameRequestRepository frameRequestRepository;
	
	public List<FrameRequest> getAllFrameRequests() {
		List<FrameRequest> frameRequests = new ArrayList<FrameRequest>();
		frameRequestRepository.findAll().forEach(frameRequests::add);
		return frameRequests;
	}
	
	public FrameRequest getFrameRequest(Long id) {
		return frameRequestRepository.findById(id).get();
	}
	
	public void addFrameRequest(FrameRequest frameRequest) {
		frameRequestRepository.save(frameRequest);		
	}
	
	public void updateFrameRequest(Long id, FrameRequest frameRequest) {
		frameRequestRepository.save(frameRequest);
	}
	
	public void deleteFrameRequest(Long id) {
		frameRequestRepository.deleteById(id);
	}
	
	public List<FrameRequest> getByFrameRequestStatus(String status) {
		List<FrameRequest> framerequest = frameRequestRepository.findByStatus(status);
		return framerequest;
	}
}
