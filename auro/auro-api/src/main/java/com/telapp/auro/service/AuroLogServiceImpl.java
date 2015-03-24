/**
 * 
 */
package com.telapp.auro.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telapp.auro.models.AuroLog;
import com.telapp.auro.rs.AuroLogService;

/**
 * @author rajunair
 *
 */
public class AuroLogServiceImpl implements AuroLogService{
	
	private final static Logger log = LoggerFactory.getLogger(AuroLogServiceImpl.class);
	public AuroLogServiceImpl(){
		
	}

	@Override
	public List<AuroLog> getAuroLog() {
		
		log.info("Executing the method getAuroLog ");
		
	    List<AuroLog> l=demoAuroLogs();
			
	   Response.status(200).entity(new GenericEntity<List<AuroLog>>(l) {}).build();
		 
		
		
		
		log.info("Finished executing the method getAuroLog ");
		return l;
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
