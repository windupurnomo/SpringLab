package com.sciencom.training.customerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sciencom.training.customerapp.model.User;
import com.sciencom.training.customerapp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public User create(@RequestBody User user){
		userService.create(user);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{username}")
	public User getByUsername(@PathVariable("username") String username){
		return userService.getByUsername(username);
	}

}
