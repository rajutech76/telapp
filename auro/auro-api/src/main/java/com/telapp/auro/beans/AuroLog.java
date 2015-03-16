/**
 * 
 */
package com.telapp.auro.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajunair
 *
 */
@XmlRootElement(name = "AuroLog")
public class AuroLog {

	private Integer auroLogId;
	private String deviceName;
	private String deviceMacId;
	private String slotname;
	private Integer slotstatus;
	private Date createdTime;
	
	
	/**
	 * @return the auroLogId
	 */
	public Integer getAuroLogId() {
		return auroLogId;
	}
	/**
	 * @param auroLogId the auroLogId to set
	 */
	public void setAuroLogId(Integer auroLogId) {
		this.auroLogId = auroLogId;
	}
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
	 * @return the slotname
	 */
	public String getSlotname() {
		return slotname;
	}
	/**
	 * @param slotname the slotname to set
	 */
	public void setSlotname(String slotname) {
		this.slotname = slotname;
	}
	/**
	 * @return the slotstatus
	 */
	public Integer getSlotstatus() {
		return slotstatus;
	}
	/**
	 * @param slotstatus the slotstatus to set
	 */
	public void setSlotstatus(Integer slotstatus) {
		this.slotstatus = slotstatus;
	}
	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuroLog [auroLogId=" + auroLogId + ", deviceName=" + deviceName
				+ ", deviceMacId=" + deviceMacId + ", slotname=" + slotname
				+ ", slotstatus=" + slotstatus + ", createdTime=" + createdTime
				+ "]";
	}
	
	
	
}
