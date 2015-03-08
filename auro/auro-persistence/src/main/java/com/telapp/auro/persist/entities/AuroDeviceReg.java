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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AuroDeviceReg generated by hbm2java
 */
@Entity
@Table(name = "auro_device_reg", catalog = "telapp_auro", uniqueConstraints = @UniqueConstraint(columnNames = "device_mac_id"))
public class AuroDeviceReg implements java.io.Serializable {

	private Integer idauroDeviceReg;
	private AuroSlotReg auroSlotReg;
	private String deviceName;
	private String deviceMacId;
	private Set<AuroSlotStatistics> auroSlotStatisticses = new HashSet<AuroSlotStatistics>(
			0);

	public AuroDeviceReg() {
	}

	public AuroDeviceReg(AuroSlotReg auroSlotReg, String deviceName,
			String deviceMacId, Set<AuroSlotStatistics> auroSlotStatisticses) {
		this.auroSlotReg = auroSlotReg;
		this.deviceName = deviceName;
		this.deviceMacId = deviceMacId;
		this.auroSlotStatisticses = auroSlotStatisticses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idauro_device_reg", unique = true, nullable = false)
	public Integer getIdauroDeviceReg() {
		return this.idauroDeviceReg;
	}

	public void setIdauroDeviceReg(Integer idauroDeviceReg) {
		this.idauroDeviceReg = idauroDeviceReg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "slot_Id")
	public AuroSlotReg getAuroSlotReg() {
		return this.auroSlotReg;
	}

	public void setAuroSlotReg(AuroSlotReg auroSlotReg) {
		this.auroSlotReg = auroSlotReg;
	}

	@Column(name = "device_name", length = 45)
	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name = "device_mac_id", unique = true, length = 250)
	public String getDeviceMacId() {
		return this.deviceMacId;
	}

	public void setDeviceMacId(String deviceMacId) {
		this.deviceMacId = deviceMacId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auroDeviceReg")
	public Set<AuroSlotStatistics> getAuroSlotStatisticses() {
		return this.auroSlotStatisticses;
	}

	public void setAuroSlotStatisticses(
			Set<AuroSlotStatistics> auroSlotStatisticses) {
		this.auroSlotStatisticses = auroSlotStatisticses;
	}

}