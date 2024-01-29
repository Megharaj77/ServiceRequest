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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "department")
public class Department implements Serializable {

	public static final long serialVersionUID = 1;

	@Id
	@Column(name = "DEPT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptId;

	@Column(name = "Department_Name")
	private String departmentName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	@JsonIgnore
	private List<SRDetails> sr_details;

	public Department() {

	}

	public Department(String departmentName, List<SRDetails> sr_details) {
		super();

		this.departmentName = departmentName;
		this.sr_details = sr_details;
	}

	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
		return "Department [deptId=" + deptId + ", departmentName=" + departmentName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentName, deptId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		return Objects.equals(departmentName, other.departmentName) && Objects.equals(deptId, other.deptId);
	}

}
