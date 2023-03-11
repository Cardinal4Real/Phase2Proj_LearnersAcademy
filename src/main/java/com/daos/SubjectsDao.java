package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Subjects;
import com.resources.DBresource;

public class SubjectsDao {

	SessionFactory sf;
	public SubjectsDao() {
		sf=DBresource.getSessionFactory();
	}
	
	public int registerSubject(Subjects subjects) {
		try {
			System.out.println("Registering subjects class");
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(subjects);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public List<Subjects> viewSubjects() {
		System.out.println("Retrieving class records");
		Session session = sf.openSession();
		TypedQuery query=session.createQuery("from Subjects");
		List<Subjects> subjectList=query.getResultList();	
		return subjectList;		
	}
	
}
