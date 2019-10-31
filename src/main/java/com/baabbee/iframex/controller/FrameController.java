package com.baabbee.iframex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.service.FrameService;
import com.baabbee.iframex.spring.config.patch.json.Patch;
import com.baabbee.iframex.spring.config.patch.json.PatchRequestBody;

@RestController
public class FrameController {
	
	@Autowired
	private FrameService frameService;
	
	@RequestMapping("/frames")
	public List<Frame> getAllFrames() {
		return frameService.getAllFrames();
	}
	
	@RequestMapping("/frames/{id}")
	public Frame getFrame(@PathVariable("id") Long id) throws EntityNotFoundException {
		return frameService.getFrame(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/frames")
	public void addFrame(@RequestBody Frame frame) {
		frame.setStatus("FRAME_INITIATED");
		frameService.addFrame(frame);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/frames/{id}")
	public void updateFrame(@RequestBody Frame frame, @PathVariable Long id) {
		frame.setId(id);
		frameService.updateFrame(id, frame);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/frames/{id}")
	public void deleteFrame(@PathVariable Long id) {
		frameService.deleteFrame(id);
	}
	@RequestMapping(method = RequestMethod.POST,value="/frame/matchframe")
	public List<Frame> getMatchedFrames(@RequestBody FrameRequest frameRequest){
		return frameService.getMatchedFrames(frameRequest);
	}
	@RequestMapping(method = RequestMethod.POST,value="frame/frames-bulk")
	public void addBulkFrame(@RequestBody List<Frame> frame) {
		for(Frame frm : frame) {
			frm.setStatus("FRAME_INITIATED");
		}
		frameService.addBulkFrame(frame);
	}
	
	@RequestMapping(value = "/frames/{id}", method = RequestMethod.PATCH,produces = MediaType.APPLICATION_JSON_VALUE)
    @Patch(service = FrameService.class, id = Long.class)
    public Frame patch(@PathVariable List<Long> id,
                       @PatchRequestBody Frame donorrequest) {
		System.out.println(donorrequest);
		frameService.save(donorrequest);
		return donorrequest;
		
    }
	
}
