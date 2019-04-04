package com.cognizant.pts.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
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
	public List<Clerk> viewAllClerks() {

		Session session= sessionFactory.openSession();
	List<Clerk> clerkList = session.createQuery("from Clerk").list();
	session.close();
	return clerkList;
	}

	@Override
	public boolean insertClerk(Clerk clerk) {
	
		Session session= sessionFactory.openSession();
		generateClerkId();
		Transaction tx= session.beginTransaction();
		session.persist(clerk);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateClerk(Clerk clerk) {
	
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.merge(clerk);
		tx.commit();
		session.close();
		return true;
	}
	
	@Override
	public Clerk viewOneClerk(String clerkId)
	{
		Session session= sessionFactory.openSession();
		Query query= session.createQuery("from Clerk o where clerkId=:clerkId");
		query.setString("clerkId", clerkId);
		Clerk clerk=(Clerk)query.uniqueResult();
		session.close();
		return clerk;
		
	}
	
	public void generateClerkId()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createSQLQuery("select CLERKSEQ.nextval from DUAL");
		Long key=((BigDecimal) query.uniqueResult()).longValue();
	    StoreClerkId.addClerkId(key.intValue());
	}
}
