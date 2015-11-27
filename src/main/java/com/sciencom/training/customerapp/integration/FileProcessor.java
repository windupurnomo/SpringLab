package com.sciencom.training.customerapp.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sciencom.training.customerapp.model.Customer;
import com.sciencom.training.customerapp.service.CustomerService;

@Component
public class FileProcessor {
	
	Logger logger = Logger.getLogger(FileProcessor.class);
	
	@Autowired
	private CustomerService customerService;
	
	public File process(File file) throws Exception{
		logger.info("Processing file: " + file);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String temp = "";
		while((temp = reader.readLine()) != null){
			String[] o = temp.split(",");
			Customer c = new Customer();
			c.setName(o[0]);
			c.setPhone(o[1]);
			c.setEmail(o[2]);
			customerService.create(c);
		}
		reader.close();
		return file;
	}
	
	
}
