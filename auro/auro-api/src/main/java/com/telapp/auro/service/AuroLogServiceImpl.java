/**
 * 
 */
package com.telapp.auro.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.telapp.auro.converter.AuroConverter;
import com.telapp.auro.models.AuroLog;
import com.telapp.auro.models.impl.AuroLogList;
import com.telapp.auro.persist.dao.AuroLogTableHome;
import com.telapp.auro.persist.entities.AuroLogTable;
import com.telapp.auro.rs.AuroLogService;

/**
 * @author rajunair
 *
 */
public class AuroLogServiceImpl implements AuroLogService{
	
	private final static Logger log = LoggerFactory.getLogger(AuroLogServiceImpl.class);
	
	@Autowired  AuroLogTableHome  auroLog ;
	
	public AuroLogServiceImpl(){
		
	}

	@Override
	public List<AuroLog> getAuroLog() {
		
		log.info("Executing the method getAuroLog ");
		
	    List<AuroLog> l=null;
	    		//l =demoAuroLogs();
	    
	  try{
	    	
	    		List<AuroLogTable> table =auroLog.getAuroLogList();
	    		if(table!=null){
	    			l=AuroConverter.convertToAuroLog(table);
	    			
	    		}else{
	    			log.warn("no log data found ");
	    		}
	    	
	    }catch(Exception exp){
	    	log.error(exp.getMessage(),exp);
	    }
	  
			
	 // Response.status(200).entity(new GenericEntity<List<AuroLog>>(l) {}).build();
		 
		
		
		
		log.info("Finished executing the method getAuroLog ");
		return l;
	}

	
	@Override
	public Response getAuroLogList() {
		log.info("Executing the method getAuroLogList ");
		
		ResponseBuilder builder = new ResponseBuilderImpl();
		
		try{		
				List<AuroLog> l =getAuroLog();
				AuroLogList list =new AuroLogList();
				list.setAuroLog(l);
				builder.entity(list);
				//builder.entity(new GenericEntity<List<AuroLog>>(l) {});
				builder.status(Status.OK);
		}catch(Exception exp){
			builder.status(Status.BAD_REQUEST);
				builder.type("application/xml");
					builder.entity("<error>Category"+ exp.getMessage() +"</error>");
					//throw new WebApplicationException(builder.build());
			 
			
			
		}
		
		log.info("Finished executing the method getAuroLogList ");
		return builder.build();
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
