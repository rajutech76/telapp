/**
 * 
 */
package com.telapp.auro.ctl;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.telapp.auro.models.AuroLog;
import com.telapp.auro.models.impl.AuroLogList;

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
		
		//List<AuroLog> auroLog = demoAuroLogs();
		
		//call for webservices 
		
		RestTemplate restTemplate = new RestTemplate();
		// String url="http://auroservice-telappauro.rhcloud.com/auroservice/services/auroLog/list";
		String url ="http://localhost:8080/auroservice/services/auroLog/auroLogList";
		
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));

		 HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 
		 
		 
		 ResponseEntity<AuroLogList> respEntity=   restTemplate.exchange(url, HttpMethod.GET, entity, AuroLogList.class);
		 
		log.info(" Response entity :"+respEntity);
		 
		 AuroLogList log =respEntity.getBody();		 
		 List<AuroLog> auroLog =log.getAuroLog();
		 
		
		
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
