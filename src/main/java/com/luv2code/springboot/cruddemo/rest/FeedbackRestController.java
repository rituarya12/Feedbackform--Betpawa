package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Feedback;
import com.luv2code.springboot.cruddemo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeedbackRestController {

	@Autowired
	private FeedbackService feedbackService;
	


	@GetMapping("/feedback")
	public List<Feedback> findAll() {
		return feedbackService.findAll();
	}


	
	@GetMapping("/feedbacks/{feedbackId}")
	public Feedback getFeedback(@PathVariable int feedbackId) {

		Feedback feedbacks = feedbackService.findById(feedbackId);
		
		if (feedbacks == null) {
			throw new RuntimeException("Feedback id not found - " + feedbackId);
		}
		
		return feedbacks;
	}

	
	@PostMapping("/feedbacks")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		
		feedback.setId(0);
		
		feedbackService.save(feedback);
		
		return feedback;
	}

	
	@PutMapping("/feedbacks")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		
		feedbackService.save(feedback);
		
		return feedback;
	}

	
	@DeleteMapping("/feedbacks/{feedbackId}")
	public String deleteFeedback(@PathVariable int feedbackId) {
		
		Feedback tempFeedback = feedbackService.findById(feedbackId);
		
		// throw exception if null
		
		if (tempFeedback == null) {
			throw new RuntimeException("Feedback id not found - " + feedbackId);
		}
		
		feedbackService.deleteById(feedbackId);
		
		return "Deleted Feedback id - " + feedbackId;
	}
	
}










