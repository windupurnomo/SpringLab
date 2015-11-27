package com.sciencom.training.customerapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciencom.training.customerapp.dao.CustomerDao;
import com.sciencom.training.customerapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());
	
	@Autowired
	private CustomerDao customerDao;
	
	public void create(Customer customer) {
		String x = cleaningPhone(customer.getPhone());
		customer.setPhone(x);
		customerDao.create(customer);
	}
	
	private String cleaningPhone(String old){
		String s = old;
		s = s.replace(" ", "");
		s = s.replace("-", "");
		s = s.replace("+62", "0");
		return s;
	}
	
	private String cleaningName(String oldName){
		String[] x = oldName.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<x.length; i++){
			String s = x[i].trim();
			char first = Character.toUpperCase(s.charAt(0));
			sb.append(first + s.substring(1)).append(" ");
		}
		return sb.toString().trim();
	}
	

	public List<Customer> read() {
		return customerDao.read();
	}

	public Customer getById(String id) {
		return customerDao.getById(id);
	}

	public void delete(String id) {
		Customer c = customerDao.getById(id);
		customerDao.delete(c);
	}

}
