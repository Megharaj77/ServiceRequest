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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="request_type")
public class RequestType implements Serializable{

	public static final long serialVersionUID=1;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TYPEDESC")
	private String typeDesc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "requestType")
	@JsonIgnore
	private List<SRDetails> sr_details;

	public RequestType() {
		
	}

	public RequestType( String typeDesc, List<SRDetails> sr_details) {
		super();
		
		this.typeDesc = typeDesc;
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
	 * @return the typeDesc
	 */
	public String getTypeDesc() {
		return typeDesc;
	}

	/**
	 * @param typeDesc the typeDesc to set
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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
		return "RequestType [id=" + id + ", typeDesc=" + typeDesc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, typeDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RequestType)) {
			return false;
		}
		RequestType other = (RequestType) obj;
		return Objects.equals(id, other.id) && Objects.equals(typeDesc, other.typeDesc);
	}

}
