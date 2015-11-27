package com.sciencom.training.customerapp.service;

import java.util.List;

import com.sciencom.training.customerapp.model.Customer;

public interface CustomerService {
	public void create(Customer customer);
	public List<Customer> read();
	public Customer getById(String id);
	public void delete(String id);
}
