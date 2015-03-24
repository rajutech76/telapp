/**
 * 
 */
package com.telapp.auro.converter;

import java.util.ArrayList;
import java.util.List;

import com.telapp.auro.beans.MqttRequest;
import com.telapp.auro.models.AuroLog;
import com.telapp.auro.persist.entities.AuroLogTable;

/**
 * @author rajunair
 *
 */
public class AuroConverter {

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
	
	
}
