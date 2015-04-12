/**
 * 
 */
package com.telapp.auro.service;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.telapp.auro.converter.AuroConverter;
import com.telapp.auro.models.AuroSlot;
import com.telapp.auro.persist.dao.AuroSlotRegHome;
import com.telapp.auro.persist.entities.AuroSlotReg;
import com.telapp.auro.rs.AuroSlotRegService;

/**
 * @author rajunair
 *
 */
public class AuroSlotRegServiceImpl implements AuroSlotRegService{
	
	private final static Logger log = LoggerFactory.getLogger(AuroSlotRegServiceImpl.class);

	@Autowired AuroSlotRegHome slotReg;
	
	@Override
	public Response addSlot(AuroSlot slot) {
	
		log.info("Executing method addSlot "+slot);
		
		ResponseBuilder builder =null;
		
		try{
				slotReg.persist(AuroConverter.toAuroSlotReg(slot));
				builder=Response.status(Status.OK);
				builder.entity(slot);
		
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
			
		}
		log.info("Finished executing the method addSlot : "+slot);
		return  builder.build();		
		
		
		
	}

	@Override
	public Response editSlot(AuroSlot slot) {
	log.info("Executing method editSlot "+slot);
		
		ResponseBuilder builder =null;
		
		try{
				slotReg.merge(AuroConverter.toAuroSlotReg(slot));
				builder=Response.status(Status.OK);
				builder.entity(slot);
		
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
			
		}
		log.info("Finished executing the method editSlot : "+slot);
		return  builder.build();		
		
	}

	@Override
	public Response getSlot() {
		
		log.info("Executing the method getSlot");
		ResponseBuilder builder =null;
		List<AuroSlotReg> reg =null;
		try{
			
			reg =slotReg.getSlots();
			builder=Response.status(Status.OK);
			if(reg!=null){
				builder.entity(AuroConverter.toAuroSlotList(reg));
			}		
	
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);			
		}finally{
			reg = null;
		}
		
		return builder.build();
	}

	@Override
	public Response getSlot(int id) {
		log.info("Executing the method getSlot  for id  "+id);
		ResponseBuilder builder =null;
		AuroSlotReg reg =null;
		try{
			
			reg =slotReg.findById(id);
			builder=Response.status(Status.OK);
			if(reg!=null){
				builder.entity(AuroConverter.toAuroSlot(reg));
			}		
	
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);			
		}finally{
			reg = null;
		}
		
		return builder.build();
	}

	@Override
	public Response removeSlot(AuroSlot slot) {
		log.info("Executing the method removeSlot "+slot);
		ResponseBuilder builder =null;
		
		try{
			
				slotReg.remove(AuroConverter.toAuroSlotReg(slot));
				builder=Response.status(Status.OK);
			
	
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);			
		}finally{
			
		}
		
		return builder.build();
	}
	
	

}
