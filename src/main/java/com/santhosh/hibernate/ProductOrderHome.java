package com.santhosh.hibernate;

// Generated May 17, 2012 5:36:33 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ProductOrder.
 * @see com.santhosh.hibernate.ProductOrder
 * @author Hibernate Tools
 */
public class ProductOrderHome {

	private static final Log log = LogFactory.getLog(ProductOrderHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ProductOrder transientInstance) {
		log.debug("persisting ProductOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductOrder instance) {
		log.debug("attaching dirty ProductOrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductOrder instance) {
		log.debug("attaching clean ProductOrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProductOrder persistentInstance) {
		log.debug("deleting ProductOrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductOrder merge(ProductOrder detachedInstance) {
		log.debug("merging ProductOrder instance");
		try {
			ProductOrder result = (ProductOrder) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductOrder findById(java.lang.Integer id) {
		log.debug("getting ProductOrder instance with id: " + id);
		try {
			ProductOrder instance = (ProductOrder) sessionFactory
					.getCurrentSession().get(
							"com.santhosh.hibernate.ProductOrder", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProductOrder> findByExample(ProductOrder instance) {
		log.debug("finding ProductOrder instance by example");
		try {
			List<ProductOrder> results = (List<ProductOrder>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.santhosh.hibernate.ProductOrder")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
