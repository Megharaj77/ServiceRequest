package com.ntt.infra.dto;

import java.util.List;


import com.ntt.infra.model.SRDetails;

public class StatusDto {

	private Integer id;
	private String stsdesc;
	private List<SRDetails>sr_details;
	
	
	public StatusDto() {
		super();
	}


	public StatusDto(Integer id, String stsdesc, List<SRDetails> sr_details) {
		super();
		this.id = id;
		this.stsdesc = stsdesc;
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
	 * @return the stsdesc
	 */
	public String getStsdesc() {
		return stsdesc;
	}


	/**
	 * @param stsdesc the stsdesc to set
	 */
	public void setStsdesc(String stsdesc) {
		this.stsdesc = stsdesc;
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
	
	
	
}
