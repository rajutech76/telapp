/**
 * 
 */
package com.telapp.auro.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author rajunair
 *
 */
public class MqttRouteBuilder extends RouteBuilder{
	
	private static final Log log = LogFactory.getLog(MqttRouteBuilder.class);
	private MqttProcessor mqTTProcessor;
	
	public MqttRouteBuilder(){
		
	}
	
	public MqttRouteBuilder(MqttProcessor mqTTProcessor){
		this.mqTTProcessor = mqTTProcessor ;
	}

	@Override
	public void configure() throws Exception 
	{
		log.info("Executing the method configure");
		
		from("mqtt:auro?host=tcp://test.mosquitto.org:1883&amp;subscribeTopicName=auro/mqtt/topic").
		transform(body().convertToString()).
		to("log:output").
		process(mqTTProcessor);
		
		
		log.info("Finished executing the method configure ");
		
	}

}
