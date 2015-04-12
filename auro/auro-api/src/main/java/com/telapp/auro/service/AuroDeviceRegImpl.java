package com.telapp.auro.service;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.telapp.auro.converter.AuroConverter;
import com.telapp.auro.models.AuroDeviceRegModel;
import com.telapp.auro.persist.dao.AuroDeviceRegHome;
import com.telapp.auro.persist.entities.AuroDeviceReg;
import com.telapp.auro.persist.entities.AuroSlotReg;
import com.telapp.auro.rs.AuroDeviceService;

public class AuroDeviceRegImpl implements AuroDeviceService{
	
	private final static Logger log = LoggerFactory.getLogger(AuroDeviceRegImpl.class);
	
	@Autowired AuroDeviceRegHome deviceHome;
	
	@Override
	public Response addSlot(AuroDeviceRegModel model) {
		
		log.info("Executing method addSlot "+model);
		
		ResponseBuilder builder =null;
		
		try{
				deviceHome.persist(AuroConverter.toAuroDeviceReg(model));
				builder=Response.status(Status.OK);
				builder.entity(model);
		
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
			
		}
		log.info("Finished executing the method addSlot : "+model);
		return  builder.build();		
		
	}

	@Override
	public Response editSlot(AuroDeviceRegModel model) {
		
		log.info("Executing method editSlot "+model);
		
		ResponseBuilder builder =null;
		
		try{
				deviceHome.merge(AuroConverter.toAuroDeviceReg(model));
				builder=Response.status(Status.OK);
				builder.entity(model);
		
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
			
		}
		log.info("Finished executing the method editSlot : "+model);
		return  builder.build();		
	}

	@Override
	public Response removeSlot(AuroDeviceRegModel model) {
		log.info("Executing method removeSlot "+model);
		
		ResponseBuilder builder =null;
		
		try{
				deviceHome.remove(AuroConverter.toAuroDeviceReg(model));
				builder=Response.status(Status.OK);
				builder.entity(model);
		
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
			
		}
		log.info("Finished executing the method removeSlot : "+model);
		return  builder.build();		
	}

	@Override
	public Response getSlot() {
		
		log.info("Executing the method getSlot");
		ResponseBuilder builder =null;
		List<AuroDeviceReg> reg =null;
		try{
			
			reg =deviceHome.getSlots();
			builder=Response.status(Status.OK);
			if(reg!=null){
				builder.entity(AuroConverter.toDeviceModellist(reg));
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
		AuroDeviceReg reg =null;
		try{
			
			reg =deviceHome.findById(id);
			builder=Response.status(Status.OK);
			if(reg!=null){
				builder.entity(AuroConverter.toAuroDeviceModel(reg));
			}		
	
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);			
		}finally{
			reg = null;
		}
		
		return builder.build();
	}
	
	
	

}
