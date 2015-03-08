/**
 * 
 */
package com.telapp.test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rajunair
 *
 */
public class Slf4jHello {

	/**
	 * @param args
	 */
	
	private final static Logger log = LoggerFactory.getLogger(Slf4jHello.class);
	
	public static void main(String[] args) {
		
		log.trace("I am trace");
		log.debug("I am debug ");
		log.info(" I am info");
		log.error("I am error ");		
		log.warn("I am warn ");
		
		
		
	
	}

}
