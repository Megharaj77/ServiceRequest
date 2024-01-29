package com.ntt.infra.dto;

import java.util.List;

import com.ntt.infra.model.SRDetails;

public class LocationDto {

	private Integer locId;
	private String locationName;
	private List<SRDetails> sr_details;
	
	
	public LocationDto() {
		super();
	}


	public LocationDto(Integer locId, String locationName, List<SRDetails> sr_details) {
		super();
		this.locId = locId;
		this.locationName = locationName;
		this.sr_details = sr_details;
	}


	/**
	 * @return the locId
	 */
	public Integer getLocId() {
		return locId;
	}


	/**
	 * @param locId the locId to set
	 */
	public void setLocId(Integer locId) {
		this.locId = locId;
	}


	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}


	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
