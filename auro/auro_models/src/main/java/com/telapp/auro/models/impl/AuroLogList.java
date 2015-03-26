/**
 * 
 */
package com.telapp.auro.models.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.telapp.auro.models.AuroLog;

/**
 * @author rajunair
 *
 */
@XmlRootElement(name = "AuroLogs")
public class AuroLogList {

	private List<AuroLog> auroLog;

	/**
	 * @return the auroLog
	 */
	public List<AuroLog> getAuroLog() {
		return auroLog;
	}

	/**
	 * @param auroLog the auroLog to set
	 */
	public void setAuroLog(List<AuroLog> auroLog) {
		this.auroLog = auroLog;
	}
	
	
}
