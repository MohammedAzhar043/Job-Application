package com.azhar.JobApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azhar.JobApplication.model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
