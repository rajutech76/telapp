package com.telapp.auro.persist.dao;

// Generated 8 Mar, 2015 9:46:02 PM by Hibernate Tools 4.0.0


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.telapp.auro.persist.entities.AuroAuth;
import com.telapp.auro.persist.entities.AuroSlotReg;

/**
 * Home object for domain model class AuroSlotReg.
 * @see com.telapp.telquiz.entity.AuroSlotReg
 * @author Hibernate Tools
 */

public class AuroSlotRegHome {

	private static final Log log = LogFactory.getLog(AuroSlotRegHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public AuroSlotRegHome(){
		
	}

	public void persist(AuroSlotReg transientInstance) {
		log.debug("persisting AuroSlotReg instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AuroSlotReg persistentInstance) {
		log.debug("removing AuroSlotReg instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AuroSlotReg merge(AuroSlotReg detachedInstance) {
		log.debug("merging AuroSlotReg instance");
		try {
			AuroSlotReg result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public List<AuroSlotReg> getSlots(){
		
		 log.debug(" executing getSlots");		 
		 List<AuroSlotReg> list =null;
		 try{
			 	list =entityManager.createQuery("from AuroSlotReg").getResultList();
		 }catch(Exception exp){
			 log.error(exp.getMessage(),exp);
		 }
		 
		 log.debug("finished executing getAllUser");		 
		 return list;
	}

	public AuroSlotReg findById(Integer id) {
		log.debug("getting AuroSlotReg instance with id: " + id);
		try {
			AuroSlotReg instance = entityManager.find(AuroSlotReg.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
