/**
 * 
 */
package com.telapp.auro.ctl;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.telapp.auro.models.AuroLog;

/**
 * @author rajugopi
 *
 */
public class AuroLogCtl extends AbstractController
{
	private static final Log log = LogFactory.getLog(AuroLogCtl.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,HttpServletResponse resp) throws Exception 
	{
		log.info(" Executing the method handleRequestInternal");
		
		List<AuroLog> auroLog = demoAuroLogs();
		
		//call for webservices 
		
		log.info("Log list recived : "+auroLog);
		
		 return new ModelAndView( "AuroList", "auroList", auroLog);
	}
	
	
	
	private static List<AuroLog> demoAuroLogs(){
		
		AuroLog log1 =new  AuroLog(1, "Test Device 1","MAC1",
									"SLOT 1", 0, new Date(System.currentTimeMillis()));
		
		AuroLog log2 =new  AuroLog(2, "Test Device 2","MAC2",
								   "SLOT 2", 1, new Date(System.currentTimeMillis()));		
		List<AuroLog> l = new ArrayList<AuroLog>();
		
		l.add(log1);
		l.add(log2);		
		
		return  l;
		
	}
	

}
