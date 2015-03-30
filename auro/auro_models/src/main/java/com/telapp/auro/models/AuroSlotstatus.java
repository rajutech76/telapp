/**
 * 
 */
package com.telapp.auro.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajunair
 *
 */

@XmlRootElement(name = "AuroSlotStatus")
		 
public class AuroSlotstatus implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	private String slotStatus;
	private String avilableSlot;
	
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
	 * @return the slotStatus
	 */
	public String getSlotStatus() {
		return slotStatus;
	}
	/**
	 * @param slotStatus the slotStatus to set
	 */
	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}
	/**
	 * @return the avilableSlot
	 */
	public String getAvilableSlot() {
		return avilableSlot;
	}
	/**
	 * @param avilableSlot the avilableSlot to set
	 */
	public void setAvilableSlot(String avilableSlot) {
		this.avilableSlot = avilableSlot;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuroSlotstatus [description=" + description + ", SlotStatus="
				+ slotStatus + ", avilableSlot=" + avilableSlot + "]";
	} 
	
	
	
	

}
