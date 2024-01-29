package com.ntt.infra.dto;





import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ntt.infra.model.Department;
import com.ntt.infra.model.Location;
import com.ntt.infra.model.RequestType;
import com.ntt.infra.model.Status;
import com.ntt.infra.model.User;

public class SRDetailsDto2 {

	private Integer reqId;
	private String locationName;
	private Integer cubicalNo;
	private String departmentName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date requiredByDate;
	private String requestType;
	private String rejectionReason;
	private String cancellationReason;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date committedDate;
	private String justification;
	private Status status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date completedDate;
	
	
	public SRDetailsDto2() {
		super();
	}

	

	public SRDetailsDto2(Integer reqId) {
		
		this.reqId = reqId;
	}



	public SRDetailsDto2(Integer reqId, String locationName, Integer cubicalNo, String departmentName,
			Date requiredByDate, String requestType, String rejectionReason, String cancellationReason,
			Date committedDate, String justification, Status status, Date completedDate) {
		super();
		this.reqId = reqId;
		this.locationName = locationName;
		this.cubicalNo = cubicalNo;
		this.departmentName = departmentName;
		this.requiredByDate = requiredByDate;
		this.requestType = requestType;
		this.rejectionReason = rejectionReason;
		this.cancellationReason = cancellationReason;
		this.committedDate = committedDate;
		this.justification = justification;
		this.status = status;
		this.completedDate = completedDate;
	}



	/**
	 * @return the reqId
	 */
	public Integer getReqId() {
		return reqId;
	}



	/**
	 * @param reqId the reqId to set
	 */
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
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
	 * @return the cubicalNo
	 */
	public Integer getCubicalNo() {
		return cubicalNo;
	}



	/**
	 * @param cubicalNo the cubicalNo to set
	 */
	public void setCubicalNo(Integer cubicalNo) {
		this.cubicalNo = cubicalNo;
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
	 * @return the requiredByDate
	 */
	public Date getRequiredByDate() {
		return requiredByDate;
	}



	/**
	 * @param requiredByDate the requiredByDate to set
	 */
	public void setRequiredByDate(Date requiredByDate) {
		this.requiredByDate = requiredByDate;
	}



	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}



	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}



	/**
	 * @return the rejectionReason
	 */
	public String getRejectionReason() {
		return rejectionReason;
	}



	/**
	 * @param rejectionReason the rejectionReason to set
	 */
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}



	/**
	 * @return the cancellationReason
	 */
	public String getCancellationReason() {
		return cancellationReason;
	}



	/**
	 * @param cancellationReason the cancellationReason to set
	 */
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}



	/**
	 * @return the committedDate
	 */
	public Date getCommittedDate() {
		return committedDate;
	}



	/**
	 * @param committedDate the committedDate to set
	 */
	public void setCommittedDate(Date committedDate) {
		this.committedDate = committedDate;
	}



	/**
	 * @return the justification
	 */
	public String getJustification() {
		return justification;
	}



	/**
	 * @param justification the justification to set
	 */
	public void setJustification(String justification) {
		this.justification = justification;
	}



	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}



	/**
	 * @return the completedDate
	 */
	public Date getCompletedDate() {
		return completedDate;
	}



	/**
	 * @param completedDate the completedDate to set
	 */
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}


	
}
