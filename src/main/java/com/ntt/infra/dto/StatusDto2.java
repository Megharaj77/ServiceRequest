package com.ntt.infra.dto;

import java.util.List;

import com.ntt.infra.model.SRDetails;
import com.ntt.infra.model.User;

public class StatusDto2 {

	
	private Integer id;
	private User user;
	
	public StatusDto2() {
		super();
	}

	public StatusDto2(Integer id, User user) {
		super();
		this.id = id;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
