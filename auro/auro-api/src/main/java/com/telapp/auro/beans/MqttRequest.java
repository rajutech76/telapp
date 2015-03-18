package com.telapp.auro.beans;

import java.sql.Date;

public class MqttRequest {

	private String deviceName;
	private String deviceMacId;
	private String description;
	private String sensorData;
	
	private Date timeToreach =new Date(System.currentTimeMillis());
	
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * @return the deviceMacId
	 */
	public String getDeviceMacId() {
		return deviceMacId;
	}
	/**
	 * @param deviceMacId the deviceMacId to set
	 */
	public void setDeviceMacId(String deviceMacId) {
		this.deviceMacId = deviceMacId;
	}
	/**
	 * @return the sensorData
	 */
	public String getSensorData() {
		return sensorData;
	}
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param sensorData the sensorData to set
	 */
	public void setSensorData(String sensorData) {
		this.sensorData = sensorData;
	}
	
	
	/**
	 * @return the timeToreach
	 */
	public Date getTimeToreach() {
		return timeToreach;
	}
	/**
	 * @param timeToreach the timeToreach to set
	 */
	public void setTimeToreach(Date timeToreach) {
		this.timeToreach = timeToreach;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MqttRequest [deviceName=" + deviceName + ", deviceMacId="
				+ deviceMacId + ", description=" + description
				+ ", sensorData=" + sensorData + ", timeToreach=" + timeToreach
				+ "]";
	}
	
	
	
}
