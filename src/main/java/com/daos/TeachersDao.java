package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Teachers;
import com.resources.DBresource;

public class TeachersDao {

	SessionFactory sf;
	public TeachersDao() {
		sf=DBresource.getSessionFactory();
	}
	
	public int registerTeacher(Teachers teachers) {
		try {
			System.out.println("Registering Teacher class");
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(teachers);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public List<Teachers> viewTeachers() {
		System.out.println("Retrieving class records");
		Session session = sf.openSession();
		TypedQuery query=session.createQuery("from Teachers");
		List<Teachers> teacherList=query.getResultList();	
		return teacherList;		
	}
	
}
