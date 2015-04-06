/**
 * 
 */
package com.telapp.auro.jpa;

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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("auro_persistance.xml");
		AuroAuthHome auth = (AuroAuthHome)context.getBean("auroUser");
		
		User user =new User();
		user.setPassword("passwd");
		user.setUserName("guest");
		
		AuroAuth au =AuroConverter.toAuroAuth(user);
		
		System.out.println(au);
		
		
		auth.persist(au);
		
		log.info("Auro log persisted ");
		
	}
}
