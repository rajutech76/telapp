/**
 * 
 */
package com.telapp.auro.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajunair
 *
 */

@XmlRootElement(name = "AuroSlot")
public class AuroSlot {

	private Integer idauroSlotReg;
	private String slotName;
	private String slotLocation;
	private String slotDescription;
	
	
	public AuroSlot(){
		
	}
	
	
	
	
	/**
	 * @return the idauroSlotReg
	 */
	public Integer getIdauroSlotReg() {
		return idauroSlotReg;
	}
	/**
	 * @param idauroSlotReg the idauroSlotReg to set
	 */
	public void setIdauroSlotReg(Integer idauroSlotReg) {
		this.idauroSlotReg = idauroSlotReg;
	}
	/**
	 * @return the slotName
	 */
	public String getSlotName() {
		return slotName;
	}
	/**
	 * @param slotName the slotName to set
	 */
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	/**
	 * @return the slotLocation
	 */
	public String getSlotLocation() {
		return slotLocation;
	}
	/**
	 * @param slotLocation the slotLocation to set
	 */
	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}
	/**
	 * @return the slotDescription
	 */
	public String getSlotDescription() {
		return slotDescription;
	}
	/**
	 * @param slotDescription the slotDescription to set
	 */
	public void setSlotDescription(String slotDescription) {
		this.slotDescription = slotDescription;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuroSlot [idauroSlotReg=" + idauroSlotReg + ", slotName="
				+ slotName + ", slotLocation=" + slotLocation
				+ ", slotDescription=" + slotDescription + "]";
	}
	
	
	
}
