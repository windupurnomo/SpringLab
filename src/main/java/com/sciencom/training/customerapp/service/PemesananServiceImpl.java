package com.sciencom.training.customerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciencom.training.customerapp.dao.CustomerDao;
import com.sciencom.training.customerapp.dao.PemesananDao;
import com.sciencom.training.customerapp.model.Customer;
import com.sciencom.training.customerapp.model.Pemesanan;
import com.sciencom.training.customerapp.viewmodel.PemesananVM;

@Service
public class PemesananServiceImpl implements PemesananService{
	
	@Autowired
	private PemesananDao pemesananDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public void create(PemesananVM pemesanan) {
		Pemesanan p = new Pemesanan();
		p.setId(pemesanan.getId());
		Customer c = customerDao.getById(pemesanan.getCustomerId());
		p.setCustomer(c);
		pemesananDao.create(p);
	}

}
