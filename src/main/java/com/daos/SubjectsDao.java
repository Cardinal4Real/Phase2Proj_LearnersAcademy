package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Subjects;
import com.resources.DBresource;

public class SubjectsDao extends Dao<Subjects,Long>{
	public SubjectsDao() {
		super(Subjects.class);
		// TODO Auto-generated constructor stub
	}
	/*
	 * public int registerSubject(Subjects subjects) { try {
	 * System.out.println("Registering subjects"); Session session =
	 * DBresource.getSession(); Transaction tran = session.getTransaction();
	 * tran.begin(); session.saveOrUpdate(subjects); tran.commit(); return 1;
	 * }catch(Exception e) { System.out.println(e); return 0; } } public
	 * List<Subjects> viewSubjects() {
	 * System.out.println("Retrieving Subjects records"); Session session =
	 * DBresource.getSession(); TypedQuery
	 * query=session.createQuery("from Subjects"); List<Subjects>
	 * subjectList=query.getResultList(); return subjectList; }
	 */
	
}
