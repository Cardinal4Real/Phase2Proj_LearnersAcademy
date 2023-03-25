package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Students;
import com.resources.DBresource;

public class StudentsDao extends Dao<Students,Long> {
	
	public StudentsDao() {
		super(Students.class);
	}
	
}
