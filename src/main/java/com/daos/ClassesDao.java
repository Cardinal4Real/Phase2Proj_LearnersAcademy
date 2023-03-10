package com.daos;

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
	
}
