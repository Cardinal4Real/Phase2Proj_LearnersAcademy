package com.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Teachers;
import com.resources.DBresource;

public abstract class Dao<T,S> {
	private Class<T> type_value;

	public Dao(Class<T> type_value) {
		this.type_value = type_value;
	}

	public int register(T t) {
		try {
		System.out.printf("Registering or updating class");
		Session session = DBresource.getSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			System.out.println(t.toString());
			session.saveOrUpdate(t);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public List<T> findAll() {
		System.out.println("Retrieving all records");
		Session session = DBresource.getSession();
		CriteriaQuery<T> criteria = session.getCriteriaBuilder().createQuery(type_value);		
		criteria.from(type_value);
		return session.createQuery(criteria).getResultList();		
	}
	public T findOne(S Id) {
		System.out.println("Finding an entity");
		Session session = DBresource.getSession();
		T entity=session.find(type_value, Id);	
		return entity;		
	}
	public void deleteOne(S Id) {
		System.out.println("Deleting an entity");
		T entity2delete=findOne(Id);
		Session session = DBresource.getSession();
        if(entity2delete != null) {
            System.out.println("deleting item with id " + Id);
            Transaction transaction = session.beginTransaction();
            session.delete(entity2delete);
            transaction.commit();
        }
        else {
            System.out.println("Could not find item with id " + Id);
        }		
	}
}
