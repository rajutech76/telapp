/**
 * 
 */
package com.telapp.auro.service;

import java.util.Random;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telapp.auro.models.AuroSlotstatus;
import com.telapp.auro.rs.AuroParkingSloatStatus;

/**
 * @author rajunair
 *
 */
public class AuroParkingStatus  implements AuroParkingSloatStatus
{
	private final static Logger log = LoggerFactory.getLogger(AuroParkingStatus.class);
	
	@Override
	public Response getParkingStatus() 
	{
		log.info("Excecuting the method ");
		
		ResponseBuilder builder = new ResponseBuilderImpl();
		AuroSlotstatus status =null ;
		try{		
				status =getAuroParkingStatus();
				builder.entity(status);
				builder.status(Status.OK);
		}catch(Exception exp){
			builder.status(Status.BAD_REQUEST);
				builder.type("application/xml");
					builder.entity("<error>Category"+ exp.getMessage() +"</error>");
					//throw new WebApplicationException(builder.build());
			 
			
			
		}
		
		log.info("Finished excecuting the method ");
		
		return builder.build();
	}
	
	private AuroSlotstatus getAuroParkingStatus(){
		
		AuroSlotstatus status = new AuroSlotstatus();
		status.setDescription("Auro Smart Parking Application");
		int devst =getDevicestatus();
		if(devst%2==0){
			status.setSlotStatus("NOT AVILABLE");
			status.setAvilableSlot(""+0);
		}else{
			status.setAvilableSlot(""+devst);
			status.setSlotStatus("AVILABLE");
		}
		
		log.info(" slot status: "+status);
		
		return status;
		
	}

	
	 private static int getDevicestatus(){
	    	int status=0;
	    	 Random randomGenerator = new Random();
	    	return status=randomGenerator.nextInt(10);
	    }
}
