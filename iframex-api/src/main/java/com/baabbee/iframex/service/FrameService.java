package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.repository.FrameRepository;

@Service
public class FrameService {
	@Autowired
	private FrameRepository frameRepository;
	
	public List<Frame> getAllFrames() {
		List<Frame> frames = new ArrayList<Frame>();
		frameRepository.findAll().forEach(frames::add);
		return frames;
	}
	
	public Frame getFrame(Long id) {
		return frameRepository.findById(id).get();
	}
	
	public void addFrame(Frame frame) {
		frameRepository.save(frame);		
	}
	
	public void updateFrame(Long id, Frame frame) {
		frameRepository.save(frame);
	}
	
	public void deleteFrame(Long id) {
		frameRepository.deleteById(id);
	}

	public List<Frame> getMatchingFrames(String size, String color, String material) {
		 List<Frame> frame=frameRepository.findBySizeAndColorAndMaterial(size,color,material);
		 return frame;
		 }

}
