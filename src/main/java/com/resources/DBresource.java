package com.resources;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBresource {

		public static SessionFactory getSessionFactory() {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			return con.buildSessionFactory();
		}
}
