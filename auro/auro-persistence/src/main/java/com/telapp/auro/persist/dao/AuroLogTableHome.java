package com.telapp.auro.persist.dao;

// Generated 8 Mar, 2015 9:46:02 PM by Hibernate Tools 4.0.0


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.telapp.auro.persist.entities.AuroLogTable;

/**
 * Home object for domain model class AuroLogTable.
 * @see com.telapp.telquiz.entity.AuroLogTable
 * @author Hibernate Tools
 */

public class AuroLogTableHome {

	private static final Log log = LogFactory.getLog(AuroLogTableHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AuroLogTable transientInstance) {
		log.debug("persisting AuroLogTable instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AuroLogTable persistentInstance) {
		log.debug("removing AuroLogTable instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AuroLogTable merge(AuroLogTable detachedInstance) {
		log.debug("merging AuroLogTable instance");
		try {
			AuroLogTable result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuroLogTable findById(Integer id) {
		log.debug("getting AuroLogTable instance with id: " + id);
		try {
			AuroLogTable instance = entityManager.find(AuroLogTable.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
