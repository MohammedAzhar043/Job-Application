package com.azhar.JobApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhar.JobApplication.model.JobPost;
import com.azhar.JobApplication.repo.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo  jobService;
	
	public void addJob(JobPost jobPost) {
		jobService.addJob(jobPost);
	}
	
	public List<JobPost> getAll(){
		return jobService.getAllJobs();
	}
	
}
