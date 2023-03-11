package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Students;
import com.resources.DBresource;

public class StudentsDao {

	SessionFactory sf;
	public StudentsDao() {
		sf=DBresource.getSessionFactory();
	}
	
	public int registerStudent(Students students) {
		try {
			System.out.println("Registering Students class");
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(students);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public List<Students> viewStudents() {
		System.out.println("Retrieving class records");
		Session session = sf.openSession();
		TypedQuery query=session.createQuery("from Students");
		List<Students> studentList=query.getResultList();	
		return studentList;		
	}
	
}
