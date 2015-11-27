package com.sciencom.training.customerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciencom.training.customerapp.dao.UserDao;
import com.sciencom.training.customerapp.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	public void create(User user) {
		userDao.create(user);
	}
	
	

}
