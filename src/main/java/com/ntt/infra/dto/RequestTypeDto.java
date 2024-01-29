package com.ntt.infra.dto;

import java.util.List;

import com.ntt.infra.model.SRDetails;

public class RequestTypeDto {

	private Integer id;
	private String typedesc;
	private List<SRDetails> sr_details;
	
	
	public RequestTypeDto() {
		super();
	}


	public RequestTypeDto(Integer id, String typedesc, List<SRDetails> sr_details) {
		super();
		this.id = id;
		this.typedesc = typedesc;
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
	 * @return the typedesc
	 */
	public String getTypedesc() {
		return typedesc;
	}


	/**
	 * @param typedesc the typedesc to set
	 */
	public void setTypedesc(String typedesc) {
		this.typedesc = typedesc;
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
