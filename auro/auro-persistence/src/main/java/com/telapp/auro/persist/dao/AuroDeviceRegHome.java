package com.telapp.auro.persist.dao;

// Generated 8 Mar, 2015 9:46:02 PM by Hibernate Tools 4.0.0


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.telapp.auro.persist.entities.AuroDeviceReg;

/**
 * Home object for domain model class AuroDeviceReg.
 * @see com.telapp.telquiz.entity.AuroDeviceReg
 * @author Hibernate Tools
 */

public class AuroDeviceRegHome {

	private static final Log log = LogFactory.getLog(AuroDeviceRegHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public AuroDeviceRegHome(){
		
	}

	public void persist(AuroDeviceReg transientInstance) {
		log.debug("persisting AuroDeviceReg instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AuroDeviceReg persistentInstance) {
		log.debug("removing AuroDeviceReg instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AuroDeviceReg merge(AuroDeviceReg detachedInstance) {
		log.debug("merging AuroDeviceReg instance");
		try {
			AuroDeviceReg result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuroDeviceReg findById(Integer id) {
		log.debug("getting AuroDeviceReg instance with id: " + id);
		try {
			AuroDeviceReg instance = entityManager
					.find(AuroDeviceReg.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
