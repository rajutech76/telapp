/**
 * 
 */
package com.telapp.auro.models;


/**
 * @author rajunair
 *
 */
public class AuroDeviceRegModel {

	
	private Integer idauroDeviceReg;
	private AuroSlot auroSlotReg;
	private String deviceName;
	private String deviceMacId;
	/**
	 * @return the idauroDeviceReg
	 */
	public Integer getIdauroDeviceReg() {
		return idauroDeviceReg;
	}
	/**
	 * @param idauroDeviceReg the idauroDeviceReg to set
	 */
	public void setIdauroDeviceReg(Integer idauroDeviceReg) {
		this.idauroDeviceReg = idauroDeviceReg;
	}
	/**
	 * @return the auroSlotReg
	 */
	public AuroSlot getAuroSlotReg() {
		return auroSlotReg;
	}
	/**
	 * @param auroSlotReg the auroSlotReg to set
	 */
	public void setAuroSlotReg(AuroSlot auroSlotReg) {
		this.auroSlotReg = auroSlotReg;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuroDeviceRegModel [idauroDeviceReg=" + idauroDeviceReg
				+ ", auroSlotReg=" + auroSlotReg + ", deviceName=" + deviceName
				+ ", deviceMacId=" + deviceMacId + "]";
	}
	
	
	
}
