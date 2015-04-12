/**
 * 
 */
package com.telapp.auro.models.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.telapp.auro.models.AuroSlot;

/**
 * @author rajunair
 *
 */
@XmlRootElement(name = "AuroSlotList")
public class AuroSlotList {
	
	List<AuroSlot> auroSlotList =null;

	/**
	 * @return the auroSlotList
	 */
	public List<AuroSlot> getAuroSlotList() {
		return auroSlotList;
	}

	/**
	 * @param auroSlotList the auroSlotList to set
	 */
	public void setAuroSlotList(List<AuroSlot> auroSlotList) {
		this.auroSlotList = auroSlotList;
	}
	
	

}
