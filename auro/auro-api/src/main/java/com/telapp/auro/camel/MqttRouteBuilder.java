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
	
	public MqttRouteBuilder(){
		
	}

	@Override
	public void configure() throws Exception 
	{
		log.info("Executing the method configure");
		
		from("mqtt:bar?subscribeTopicName=auro/mqtt/topic").
		transform(body().convertToString()).
		to("log:output").
		to("mock:result");
		
		log.info("Finished executing the method configure ");
		
	}

}
