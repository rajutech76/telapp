/**
 * 
 */
package com.telapp.auro.jpa;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.telapp.auro.persist.dao.AuroLogTableHome;
import com.telapp.auro.persist.entities.AuroLogTable;

/**
 * @author rajunair
 *
 */
public class AuroLogTest {

	private final static Logger log = LoggerFactory.getLogger(AuroLogTest.class);
	public static void main(String args[])throws Exception
	{
		
		log.info("Executing the test cases for AuroLogTest");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("auro_persistance.xml");
		AuroLogTableHome auroLog = (AuroLogTableHome)context.getBean("auroLog");
		
		
		//AuroLogTable table =new AuroLogTable("testdevicename", "testmacId", "slotname1",
			//	0,new Date(System.currentTimeMillis()));
		
		//auroLog.persist(table);
		
		log.info("Auro log persisted ");
		
	}
}
