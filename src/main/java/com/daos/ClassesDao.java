package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Classes;
import com.resources.DBresource;

public class ClassesDao {

	SessionFactory sf;
	public ClassesDao() {
		sf=DBresource.getSessionFactory();
	}
	
	public int registerClass(Classes classes) {
		try {
			System.out.println("Registering class");
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(classes);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public List<Classes> viewClass() {
		System.out.println("Retrieving class records");
		Session session = sf.openSession();
		TypedQuery query=session.createQuery("from Classes");
		List<Classes> classList=query.getResultList();	
		return classList;		
	}
	
}
