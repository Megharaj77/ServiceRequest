package com.ntt.infra.dto;

import java.util.List;
import com.ntt.infra.model.SRDetails;

public class UserDto {

	private Integer id;
	private String name;
	private String passwd;
	private Integer roleId;
	private List<SRDetails> sr_details;
	
	
	public UserDto() {
		super();
	}


	public UserDto(Integer id, String name, String passwd, Integer roleId, List<SRDetails> sr_details) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.roleId = roleId;
		this.sr_details = sr_details;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	


	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}


	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}


	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	/**
	 * @return the sr_details
	 */
	public List<SRDetails> getSr_details() {
		return sr_details;
	}


	/**
	 * @param sr_details the sr_details to set
	 */
	public void setSr_details(List<SRDetails> sr_details) {
		this.sr_details = sr_details;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", passwd=" + passwd + ", roleId=" + roleId + ", sr_details="
				+ sr_details + "]";
	}
	
	
	
}
