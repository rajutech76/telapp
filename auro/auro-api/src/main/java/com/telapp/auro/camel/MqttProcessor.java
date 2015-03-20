package com.telapp.auro.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.telapp.auro.beans.MqttRequest;
import com.telapp.auro.converter.AuroConverter;
import com.telapp.auro.persist.dao.AuroLogTableHome;
import com.telapp.auro.persist.entities.AuroLogTable;

public class MqttProcessor implements  Processor {

	@Autowired  AuroLogTableHome  auroLog ;
	
	private static final Log log = LogFactory.getLog(MqttProcessor.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		
		String body = exchange.getIn().getBody().toString();
		
		log.info("Executing the method process : "+body
				+" header :"+exchange.getIn().getHeaders());
		
		
		
		MqttRequest mqTT =convertToMQTT(body);
		saveData(mqTT);
		log.info("Finished executing the method process");
		
	}
	
	private void saveData(MqttRequest mqTT){
		log.debug("executing save data :"+mqTT);
		AuroLogTable auroTable = AuroConverter.convertToAuroConverter(mqTT);
		auroLog.persist(auroTable);
		
	}
	
	
	private MqttRequest convertToMQTT(String body){
		
		//log.info("body : "+body);
		
		MqttRequest mqTT =new MqttRequest();
		
		String str[] =body.split("_");
		if(str!=null && str.length>3){
		
			mqTT.setDeviceName(str[0]);
			mqTT.setDeviceMacId(str[1]);
			mqTT.setDescription(str[2]);
			mqTT.setSensorData(str[3]);
		}
		
		return mqTT;
	}

}
