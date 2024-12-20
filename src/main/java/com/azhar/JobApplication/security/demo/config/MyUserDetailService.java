package com.azhar.JobApplication.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.azhar.JobApplication.model.User;
import com.azhar.JobApplication.repo.UserRepo;



@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.repo.findByUsername(username);

		if (user == null) {
			System.out.println("user 404");
			throw new UsernameNotFoundException("user 404");
		}

		return new MyUserDetail(user);
	}

}