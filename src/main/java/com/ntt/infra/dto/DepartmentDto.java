package com.ntt.infra.dto;

import java.util.List;

import com.ntt.infra.model.SRDetails;

public class DepartmentDto {

	private Integer deptId;
	private String departmentName;
	private List<SRDetails> sr_details;
	
	public DepartmentDto() {
		
	}

	public DepartmentDto(Integer deptId, String departmentName, List<SRDetails> sr_details) {
		
		this.deptId = deptId;
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
	
	
}
