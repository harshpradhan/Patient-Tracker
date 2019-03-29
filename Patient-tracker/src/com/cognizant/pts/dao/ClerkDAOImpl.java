package com.cognizant.pts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.pts.entity.Clerk;

@Repository("ClerkDAOImpl")
public class ClerkDAOImpl implements ClerkDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Clerk> getAllClerks() {

		Session session= sessionFactory.openSession();
	List<Clerk> clerkList = session.createQuery("from Clerk").list();
	session.close();
	return clerkList;
	}

	@Override
	public boolean insertClerk(Clerk clerk) {
	
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.persist(clerk);
		tx.commit();
		session.close();
		return true;
	}

}
