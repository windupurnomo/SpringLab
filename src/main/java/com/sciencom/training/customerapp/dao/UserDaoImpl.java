package com.sciencom.training.customerapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sciencom.training.customerapp.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.flush();
	}

	public User getByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username = :u");
		query.setParameter("u", username);
		List l = query.list();
		return l.size() <= 0 ? null : (User)l.get(0);
	}

}
