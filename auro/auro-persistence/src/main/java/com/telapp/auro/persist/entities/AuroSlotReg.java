package com.telapp.auro.persist.entities;

// Generated 8 Mar, 2015 9:42:55 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AuroSlotReg generated by hbm2java
 */
@Entity
@Table(name = "auro_slot_reg", catalog = "telapp_auro")
public class AuroSlotReg implements java.io.Serializable {

	private Integer idauroSlotReg;
	private String slotName;
	private String slotLocation;
	private String slotDescription;
	private Set<AuroDeviceReg> auroDeviceRegs = new HashSet<AuroDeviceReg>(0);

	public AuroSlotReg() {
	}

	public AuroSlotReg(String slotName, String slotLocation,
			String slotDescription, Set<AuroDeviceReg> auroDeviceRegs) {
		this.slotName = slotName;
		this.slotLocation = slotLocation;
		this.slotDescription = slotDescription;
		this.auroDeviceRegs = auroDeviceRegs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idauro_slot_reg", unique = true, nullable = false)
	public Integer getIdauroSlotReg() {
		return this.idauroSlotReg;
	}

	public void setIdauroSlotReg(Integer idauroSlotReg) {
		this.idauroSlotReg = idauroSlotReg;
	}

	@Column(name = "slot_name", length = 45)
	public String getSlotName() {
		return this.slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	@Column(name = "slot_location", length = 250)
	public String getSlotLocation() {
		return this.slotLocation;
	}

	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}

	@Column(name = "slot_description", length = 45)
	public String getSlotDescription() {
		return this.slotDescription;
	}

	public void setSlotDescription(String slotDescription) {
		this.slotDescription = slotDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auroSlotReg")
	public Set<AuroDeviceReg> getAuroDeviceRegs() {
		return this.auroDeviceRegs;
	}

	public void setAuroDeviceRegs(Set<AuroDeviceReg> auroDeviceRegs) {
		this.auroDeviceRegs = auroDeviceRegs;
	}

}
