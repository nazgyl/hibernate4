package com.santhosh.hibernate;

// Generated May 17, 2012 6:00:22 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Customer.
 * @see com.santhosh.hibernate.Customer
 * @author Hibernate Tools
 */
@Stateless
public class CustomerHome {

	private static final Log log = LogFactory.getLog(CustomerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Customer transientInstance) {
		log.debug("persisting Customer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Customer persistentInstance) {
		log.debug("removing Customer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Customer merge(Customer detachedInstance) {
		log.debug("merging Customer instance");
		try {
			Customer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customer findById(int id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = entityManager.find(Customer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
