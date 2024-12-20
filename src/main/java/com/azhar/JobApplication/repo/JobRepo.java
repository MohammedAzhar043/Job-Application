package com.azhar.JobApplication.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.azhar.JobApplication.model.JobPost;

@Repository
public class JobRepo {

	List<JobPost> jobPosts = new ArrayList<>(Arrays.asList(
			new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
			(new JobPost(2, "python Developer", "Must have good experience in core python and advanced python", 2,
					List.of("Core python", "J2EE", "Spring Boot", "Hibernate"))),
			(new JobPost(3, "c++ Developer", "Must have good experience in core Java and advanced Java", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"))),
			(new JobPost(4, "c Developer", "Must have good experience in core Java and advanced Java", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"))),
			(new JobPost(5, "sql Developer", "Must have good experience in core Java and advanced Java", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")))));

	/* List<JobPost> jobPosts = new ArrayList<>(); */

	public List<JobPost> getAllJobs() {
		return jobPosts;
	}

	public void addJob(JobPost jobPost) {
		jobPosts.add(jobPost);
		System.out.println(jobPost);
	}
}
