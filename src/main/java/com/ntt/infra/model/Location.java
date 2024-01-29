package com.ntt.infra.model;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "location")
public class Location implements Serializable {

	public static final long serialVersionUID = 1;

	@Id
	@Column(name = "LOC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locId;

	@Column(name = "Location_Name")
	private String locationName;

	@OneToMany(mappedBy = "location")
	@JsonIgnore
	private List<SRDetails> sr_details;

	public Location() {

	}

	public Location(String locationName, List<SRDetails> sr_details) {
		super();

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

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locationName=" + locationName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(locId, locationName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Location)) {
			return false;
		}
		Location other = (Location) obj;
		return Objects.equals(locId, other.locId) && Objects.equals(locationName, other.locationName);
	}

}
