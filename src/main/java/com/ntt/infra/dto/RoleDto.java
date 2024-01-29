package com.ntt.infra.dto;

import java.util.List;

import com.ntt.infra.model.User;

public class RoleDto {

	private Integer id;
	private String name;
	private List<User>user;
	
	public RoleDto() {
		
	}

	public RoleDto(Integer id, String name, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
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
	 * @return the user
	 */
	public List<User> getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}


	
	
}
