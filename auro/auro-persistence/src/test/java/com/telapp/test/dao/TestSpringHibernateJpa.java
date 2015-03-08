/**
 * 
 */
package com.telapp.test.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author raju
 *
 */
public class TestSpringHibernateJpa
{
	
	private final static Logger log = LoggerFactory.getLogger(TestSpringHibernateJpa.class);
	
		public static void main(String args[]) throws Exception
		{
				log.info("Executing main method ");
				
				ApplicationContext context = new ClassPathXmlApplicationContext("telquiz_persistance.xml");
				/*UserRegTableHome reg = (UserRegTableHome)context.getBean("userReg");
				
				UserRegTable  user =new UserRegTable();
				
				user.setDeviceid("SAMSUNG_65");
				user.setOperatotName("vodafone");
				user.setUserMsisdn("9986642298");
				
				
				reg.persist(user);
				*/
				
				log.info(" channel  persisted ");
				
		/*List<ChannelReg>  c = reg.getAllChannels();
			
			for(ChannelReg cr :c){
				log.info(cr.toString());
			}
			
			log.info(channel.toString());
		
		*/		
			
		}

}
