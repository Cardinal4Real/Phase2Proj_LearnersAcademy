package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Teachers;
import com.resources.DBresource;

public class TeachersDao extends Dao<Teachers,Long> {

	public TeachersDao() {
		super(Teachers.class);
		// TODO Auto-generated constructor stub
	}
}
