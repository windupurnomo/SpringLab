package com.sciencom.training.customerapp.dao;

import java.util.List;

import com.sciencom.training.customerapp.model.Customer;

public interface CustomerDao {
	public void create(Customer customer);
	public List<Customer> read();
	public void update(Customer customer);
	public void delete(Customer customer);
	
	public Customer getById(String id);
	public Customer getByEmail(String email);
}
