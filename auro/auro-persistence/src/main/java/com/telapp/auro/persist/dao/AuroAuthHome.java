package com.telapp.auro.persist.dao;

// Generated 8 Mar, 2015 9:46:02 PM by Hibernate Tools 4.0.0


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.telapp.auro.persist.entities.AuroAuth;

/**
 * Home object for domain model class AuroAuth.
 * @see com.telapp.telquiz.entity.AuroAuth
 * @author Hibernate Tools
 */
@Repository("auroUser")
public class AuroAuthHome {

	private static final Log log = LogFactory.getLog(AuroAuthHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public AuroAuthHome(){}

	public void persist(AuroAuth transientInstance) {
		log.debug("persisting AuroAuth instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AuroAuth persistentInstance) {
		log.debug("removing AuroAuth instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AuroAuth merge(AuroAuth detachedInstance) {
		log.debug("merging AuroAuth instance");
		try {
			AuroAuth result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	
	 public AuroAuth findUser(AuroAuth auth) {
		 AuroAuth user=null;
         Query q = entityManager.createQuery("SELECT u FROM AuroAuth u WHERE u.username = :userName and u.password :passwd");
         q.setParameter("userName", auth.getUsername());
         q.setParameter("passwd", auth.getPassword());
         
         try{ 
        	 user =(AuroAuth) q.getSingleResult();
         }  
         catch(Exception e){ 	          
        	 log.error(e.getMessage(),e);
         } 
         
         return user;
  	}
	
		
	public AuroAuth findById(Integer id) {
		log.debug("getting AuroAuth instance with id: " + id);
		try {
			AuroAuth instance = entityManager.find(AuroAuth.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
