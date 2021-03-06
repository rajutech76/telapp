/**
 * 
 */
package com.telapp.auro.converter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telapp.auro.beans.MqttRequest;
import com.telapp.auro.models.AuroDeviceRegModel;
import com.telapp.auro.models.AuroLog;
import com.telapp.auro.models.AuroSlot;
import com.telapp.auro.models.User;
import com.telapp.auro.persist.entities.AuroAuth;
import com.telapp.auro.persist.entities.AuroDeviceReg;
import com.telapp.auro.persist.entities.AuroLogTable;
import com.telapp.auro.persist.entities.AuroSlotReg;

/**
 * @author rajunair
 *
 */
public class AuroConverter {
	
	private final static Logger log = LoggerFactory.getLogger(AuroConverter.class);

	public static AuroLogTable convertToAuroConverter(MqttRequest mqt){
		
		AuroLogTable log =new AuroLogTable();
		
		log.setCreatedTime(mqt.getTimeToreach());
		log.setDeviceMacId(mqt.getDeviceMacId());
		log.setDeviceName(mqt.getDeviceName());
		log.setSlotstatus(Integer.parseInt(mqt.getSensorData()));
		log.setSlotname(mqt.getDescription());
		
		return log;
		
	}
	
	public static List<AuroLog> convertToAuroLog(List<AuroLogTable> l){
		
		List<AuroLog> log =new ArrayList<AuroLog>();
		
		for(AuroLogTable t:l){
		
			log.add(converAuroLog(t));
		}
		
		return log;
		
	}
	
	public static AuroLog converAuroLog(AuroLogTable t){
		AuroLog log = new AuroLog();
		
		log.setAuroLogId(t.getAuroLogId());
		log.setCreatedTime(t.getCreatedTime());
		log.setDeviceMacId(t.getDeviceMacId());
		log.setDeviceName(t.getDeviceName());
		log.setSlotname(t.getSlotname());
		log.setSlotstatus(t.getSlotstatus());	
		
		return log;
		
	}
	
	public static User toUser(AuroAuth auth){
		
		User user= null;
		try{
			
				user.setPassword(auth.getPassword());
				user.setUserId(auth.getAuthId());
				user.setUserName(auth.getUsername());
			
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
		}
		return user;
	}
	
	
	public static List<User> toUserList(List<AuroAuth> l){
		
		List<User> user =new ArrayList<User>();
		for(AuroAuth a:l){
			user.add(toUser(a));
		}
		return user;
		
	}
	
	
	public static AuroAuth toAuroAuth(User user){
		
		AuroAuth auth =null;
		try{
		if(user!=null)
		{
			auth =new AuroAuth();
			
			auth.setCreateTime(new Date(System.currentTimeMillis()));
			auth.setPassword(user.getPassword());
			auth.setUsername(user.getUserName());
			if(user.getUserId()>0){
			auth.setAuthId(user.getUserId());
			}
		
		}
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
		}
		
		return auth;
	}
	
	
	public static AuroSlotReg toAuroSlotReg(AuroSlot slot){		
		AuroSlotReg reg =null;		
		try{
				if(slot==null){
					throw new Exception("null data ");
				}
				
				reg =new AuroSlotReg();
				reg.setIdauroSlotReg(slot.getIdauroSlotReg());
				reg.setSlotDescription(slot.getSlotDescription());
				reg.setSlotLocation(slot.getSlotLocation());
				reg.setSlotName(slot.getSlotName());
			
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
		}
		return reg;
		
	}
	
	public static AuroSlot toAuroSlot(AuroSlotReg slot){
		
		AuroSlot reg =null;		
		try{
				if(slot==null){
					throw new Exception("null data ");
				}
				
				reg =new AuroSlot();
				reg.setIdauroSlotReg(slot.getIdauroSlotReg());
				reg.setSlotDescription(slot.getSlotDescription());
				reg.setSlotLocation(slot.getSlotLocation());
				reg.setSlotName(slot.getSlotName());
			
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
		}
		return reg;
		
	}
	
	public static List<AuroSlot> toAuroSlotList(List<AuroSlotReg> list){
		
		List<AuroSlot> slot =null;
		AuroSlot s  =null;
		for(AuroSlotReg r :list){
			
			 s =toAuroSlot(r);
			if(slot==null){
				slot =new ArrayList<AuroSlot>();
			}
			slot.add(s);
		}
		return slot;
		
	}
	
	
	public static AuroDeviceReg toAuroDeviceReg(AuroDeviceRegModel model){
		
		AuroDeviceReg reg = null;
		
		try{
				if(model==null){
					throw new Exception("null data ");
				}
				
				AuroSlotReg sr = toAuroSlotReg(model.getAuroSlotReg());
				reg = new AuroDeviceReg();
				reg.setAuroSlotReg(sr);
				reg.setDeviceMacId(model.getDeviceMacId());
				reg.setDeviceName(model.getDeviceName());
				reg.setIdauroDeviceReg(model.getIdauroDeviceReg());
						
			
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
		}
		
		return reg;
	}
	
	
	public static AuroDeviceRegModel toAuroDeviceModel(AuroDeviceReg model){
		AuroDeviceRegModel reg = null;
		
		try{
				if(model==null){
					throw new Exception("null data ");
				}
				
				AuroSlot sr = toAuroSlot(model.getAuroSlotReg());
				
				reg = new AuroDeviceRegModel();
				reg.setAuroSlotReg(sr);
				reg.setDeviceMacId(model.getDeviceMacId());
				reg.setDeviceName(model.getDeviceName());
				reg.setIdauroDeviceReg(model.getIdauroDeviceReg());
						
			
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
		}
		
		return reg;
		
	}
	
	
	public static List<AuroDeviceRegModel> toDeviceModellist(List<AuroDeviceReg> list){
		
		List<AuroDeviceRegModel> slot =null;
		AuroDeviceRegModel s  =null;
		for(AuroDeviceReg r :list){
			
			 s =toAuroDeviceModel(r);
			if(slot==null){
				slot =new ArrayList<AuroDeviceRegModel>();
			}
			slot.add(s);
		}
		return slot;
	}
	
	
}
