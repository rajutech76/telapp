/**
 * 
 */
package com.telapp.auro.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.telapp.auro.converter.AuroConverter;
import com.telapp.auro.models.User;
import com.telapp.auro.persist.dao.AuroAuthHome;
import com.telapp.auro.persist.entities.AuroAuth;

/**
 * @author rajunair
 *
 */
public class UserDaoTest {
	private final static Logger log = LoggerFactory.getLogger(AuroLogTest.class);
	public static void main(String args[])throws Exception
	{
		
		log.info("Executing the test cases for AuroLogTest");
		
		//
		
		ApplicationContext context = new ClassPathXmlApplicationContext("auro_persistance_h2.xml");
		AuroAuthHome auth = (AuroAuthHome)context.getBean("auroUser");
		
		User user =new User();
		user.setPassword("passwd");
		user.setUserName("raju");
		
		AuroAuth au =AuroConverter.toAuroAuth(user);
		
		System.out.println(au);
		
		
		auth.persist(au);
		
		
		List<AuroAuth> l = auth.getAllUser(0, 0);
		
		for(AuroAuth a:l){
			log.info("data in tables -------->" +a.toString());
		}
		
		log.info("Auro log persisted ");
		
	}
	
	
}
