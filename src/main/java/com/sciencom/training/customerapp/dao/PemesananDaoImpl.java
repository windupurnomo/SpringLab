package com.sciencom.training.customerapp.dao;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sciencom.training.customerapp.model.Customer;
import com.sciencom.training.customerapp.model.Pemesanan;

@Repository
public class PemesananDaoImpl implements PemesananDao{
	final static Logger logger = Logger.getLogger(PemesananDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerDao customerDao;
	
	public void create(Pemesanan pemesanan) {
		pemesanan.setId(UUID.randomUUID().toString());
		Session session = sessionFactory.openSession();
		session.save(pemesanan);
		session.flush();
	}

	public List<Pemesanan> read() {
		return null;
	}

}
