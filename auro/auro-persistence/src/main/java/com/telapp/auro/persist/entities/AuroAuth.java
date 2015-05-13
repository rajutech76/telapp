package com.telapp.auro.persist.entities;

// Generated 8 Mar, 2015 9:42:55 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AuroAuth generated by hbm2java
 */
@Entity
//@Table(name = "auro_auth", catalog = "telapp_auro")
@Table(name = "auro_auth")
public class AuroAuth implements java.io.Serializable {

	private Integer authId;
	private String username;
	private String password;
	private Date createTime;
	private Date updateTime;
	private String createdUser;

	public AuroAuth() {
	}

	public AuroAuth(String username, String password, Date createTime,
			Date updateTime, String createdUser) {
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.createdUser = createdUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "auth_id", unique = true, nullable = false)
	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "created_user", length = 45)
	public String getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuroAuth [authId=" + authId + ", username=" + username
				+ ", password=" + password + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", createdUser=" + createdUser
				+ "]";
	}

	
}
