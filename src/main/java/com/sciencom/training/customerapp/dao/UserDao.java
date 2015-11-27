package com.sciencom.training.customerapp.dao;

import com.sciencom.training.customerapp.model.User;

public interface UserDao {
	public void create(User user);
	public User getByUsername(String username);
}
