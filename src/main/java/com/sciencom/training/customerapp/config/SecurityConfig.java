package com.sciencom.training.customerapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userSecuritySvc")
	private UserDetailsService userSecuritySvc;
	
	@Autowired
	public void configureGlobalsecurity(AuthenticationManagerBuilder auth) 
			throws Exception{
		auth.userDetailsService(userSecuritySvc);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/api/**").authenticated()
		.antMatchers(HttpMethod.PUT, "/api/**").authenticated()
		.antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
		.anyRequest().permitAll()
		.and().httpBasic()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
