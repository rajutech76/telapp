/**
 * 
 */
package com.telapp.auro.models.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.telapp.auro.models.User;

/**
 * @author rajunair
 *
 */
@XmlRootElement(name = "UserList")
public class UserList {
	
	private List<User> userList= null;

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	

}
