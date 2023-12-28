package com.rahul.SpringWebThymeleaf.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSpring {
	
	//@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
						auth -> {
							auth.anyRequest().authenticated();
						});
		
		http.sessionManagement(
						session -> 
							session.sessionCreationPolicy(
									SessionCreationPolicy.STATELESS)
						);
		
		http.formLogin();
		http.httpBasic();
		
		http.csrf().disable();
		
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailService() {
		
		var user = User.withUsername("RAHUL")
			.password("{noop}1234")
			.roles("USER")
			.build();

		
		var admin = User.withUsername("admin")
				.password("{noop}12345")
				.roles("ADMIN")
				.build();

		var user2 = User.withUsername("balram")
				.password("{noop}3221")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin,user2);
	}



}
