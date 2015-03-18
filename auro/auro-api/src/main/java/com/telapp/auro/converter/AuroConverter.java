/**
 * 
 */
package com.telapp.auro.converter;

import com.telapp.auro.beans.MqttRequest;
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
	
	
}
