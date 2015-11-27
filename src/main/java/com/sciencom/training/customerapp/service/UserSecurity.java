package com.sciencom.training.customerapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sciencom.training.customerapp.model.User;

@Service("userSecuritySvc")
public class UserSecurity implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User u = userService.getByUsername(arg0);
		if (u == null){
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return new org.springframework.security.core
				.userdetails.User(u.getUsername(), u.getPassword(), authorities);
	}
	
}
