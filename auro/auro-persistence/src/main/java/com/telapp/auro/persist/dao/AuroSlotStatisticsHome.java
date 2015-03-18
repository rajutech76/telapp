package com.telapp.auro.persist.dao;

// Generated 8 Mar, 2015 9:46:02 PM by Hibernate Tools 4.0.0


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.telapp.auro.persist.entities.AuroSlotStatistics;

/**
 * Home object for domain model class AuroSlotStatistics.
 * @see com.telapp.telquiz.entity.AuroSlotStatistics
 * @author Hibernate Tools
 */

public class AuroSlotStatisticsHome {

	private static final Log log = LogFactory
			.getLog(AuroSlotStatisticsHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public AuroSlotStatisticsHome(){
		
	}

	public void persist(AuroSlotStatistics transientInstance) {
		log.debug("persisting AuroSlotStatistics instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AuroSlotStatistics persistentInstance) {
		log.debug("removing AuroSlotStatistics instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AuroSlotStatistics merge(AuroSlotStatistics detachedInstance) {
		log.debug("merging AuroSlotStatistics instance");
		try {
			AuroSlotStatistics result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuroSlotStatistics findById(Integer id) {
		log.debug("getting AuroSlotStatistics instance with id: " + id);
		try {
			AuroSlotStatistics instance = entityManager.find(
					AuroSlotStatistics.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
