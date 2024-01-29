package com.ntt.infra.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="status")
public class Status implements Serializable{

	public static final long serialVersionUID=1;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="STSDESC")
	private String stsDesc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "status")
	@JsonIgnore
	private List<SRDetails>sr_details;

	public Status() {
		super();
	}

	public Status( String stsDesc, List<SRDetails> sr_details) {
		super();
		this.stsDesc = stsDesc;
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
	 * @return the stsDesc
	 */
	public String getStsDesc() {
		return stsDesc;
	}

	/**
	 * @param stsDesc the stsDesc to set
	 */
	public void setStsDesc(String stsDesc) {
		this.stsDesc = stsDesc;
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
		return "Status [id=" + id + ", stsDesc=" + stsDesc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sr_details);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Status)) {
			return false;
		}
		Status other = (Status) obj;
		return Objects.equals(id, other.id) && Objects.equals(sr_details, other.sr_details);
	}

	
	
	
}
