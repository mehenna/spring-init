package com.mmi.review.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Securityconfiguration  extends WebSecurityConfigurerAdapter {
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() {
		UserDetails user=User.withUsername("user").password("{noop}test").roles("USER").build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/","/todo*/*").access("hasRole('USER')")
			.and().formLogin();
		
	}
}
