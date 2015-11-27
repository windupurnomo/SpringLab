package com.sciencom.training.customerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sciencom.training.customerapp.model.Customer;
import com.sciencom.training.customerapp.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Customer create (@RequestBody Customer customer) {
		customerService.create(customer);
		return customer;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Customer> get(){
		return customerService.read();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Customer getById(@PathVariable("id") String id){
		return customerService.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void delete(@PathVariable("id") String id){
		customerService.delete(id);
	}
	
}