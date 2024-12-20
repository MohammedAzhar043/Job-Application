package com.azhar.JobApplication.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private MyUserDetailService userDetailsService;

	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		  1st step 
		http.csrf(customizer -> customizer.disable());
//		  enabling the security filter chain 
		http.authorizeHttpRequests(resuest -> resuest.anyRequest().authenticated());

//		  http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		/*
		 * Customizer<CsrfConfigurer<HttpSecurity>> custCsrf =
		 * (CsrfConfigurer<HttpSecurity> t) -> { t.disable();
		 * 
		 * }; http.csrf(custCsrf);
		 * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		 * AuthorizationManagerRequestMatcherRegistry> customizer = new
		 * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		 * AuthorizationManagerRequestMatcherRegistry>() {
		 * 
		 * @Override public void customize(
		 * AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		 * AuthorizationManagerRequestMatcherRegistry t) { // TODO Auto-generated method
		 * stub t.anyRequest().authenticated(); } };
		 * 
		 * http.authorizeHttpRequests(customizer);
		 */
		return http.build();

	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		UserDetails user = User.withDefaultPasswordEncoder().username("azhar").password("123").roles("USER").build();
//		UserDetails admin = User.withDefaultPasswordEncoder().username("junaid").password("123").roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	
}