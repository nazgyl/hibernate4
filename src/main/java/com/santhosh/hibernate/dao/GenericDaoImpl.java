package com.santhosh.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public PK create(T o) {
        return (PK) getSession().save(o);
    }

    public T read(PK id) {
        return (T) getSession().get(type, id);
    }

    public void update(T o) {
        getSession().update(o);
    }

    public void delete(T o) {
        getSession().delete(o);
    }
    
    public void merge(T o) {
        getSession().merge(o);
    }

}
