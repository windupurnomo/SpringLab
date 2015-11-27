package com.sciencom.training.customerapp.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sciencom.training.customerapp.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		Session session = sessionFactory.openSession();
		session.save(customer);
		session.flush();
	}

	public List<Customer> read() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		Query q = session.createQuery(hql);
		return q.list();
	}

	public void update(Customer customer) {
		Session session = sessionFactory.openSession();
		session.update(customer);
		session.flush();
	}

	public void delete(Customer customer) {
		Session session = sessionFactory.openSession();
		session.delete(customer);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public Customer getByEmail(String email) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where email = :xxx";
		Query q = session.createQuery(hql);
		q.setParameter("xxx", email);
		
		List<Customer> l = q.list();
		return (Customer) (l.size() > 0 ? l.get(0) : null);
	}

	public Customer getById(String id) {
		Session session = sessionFactory.openSession();
        return (Customer) session.get(Customer.class, id);
	}


}
