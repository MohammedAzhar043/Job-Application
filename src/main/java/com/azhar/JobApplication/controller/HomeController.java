package com.azhar.JobApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.azhar.JobApplication.model.JobPost;
import com.azhar.JobApplication.service.JobService;

@Controller
public class HomeController {

	@Autowired
	private JobService jobService;

	@GetMapping({ "/", "home" })
	public String home() {
		return "home";
	}

	@RequestMapping("/addjob")
	public String addJob() {
		return "addjob";
	}

	@PostMapping("/handleForm")
	public String handleForm(JobPost jobPost) {

		jobService.addJob(jobPost);
		return "success";
	}

	@GetMapping("/viewalljobs")
	public String viewAllJob(Model m) {

		List<JobPost> jobPosts = this.jobService.getAll();
		m.addAttribute("jobPosts", jobPosts);
		return "viewalljobs";
	}
	
	
}
