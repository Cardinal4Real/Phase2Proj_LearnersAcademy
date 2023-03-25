package com.resources;
import javax.persistence.FlushModeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBresource {
	
		private static Session session;
		
		private static SessionFactory getSessionFactory() {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			return con.buildSessionFactory();
		}
		
		public static Session getSession() {
			if((session==null)||!session.isOpen()||!session.isConnected()) {
				session=getSessionFactory().openSession();
				session.setFlushMode(FlushModeType.COMMIT);
			}			
			return session;
		}
		

}
