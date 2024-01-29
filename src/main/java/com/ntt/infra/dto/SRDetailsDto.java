package com.ntt.infra.dto;










import java.util.Date;

import com.ntt.infra.model.Department;
import com.ntt.infra.model.Location;
import com.ntt.infra.model.RequestType;
import com.ntt.infra.model.Status;
import com.ntt.infra.model.User;

public class SRDetailsDto {

	private Integer reqId;
	private User user;
	private Location location;
	private Integer cubicalNo;
	private Department department;
	private Date requiredByDate;
	private RequestType requestType;
	private String rejectionReason;
	private String cancellationReason;
	private Date requestedDate;
	private Date assignedDate;
	private Date committedDate;
	private Date completedDate;
	private String justification;
	private Status status;
	
	
	public SRDetailsDto() {
		super();
	}


	public SRDetailsDto(Integer reqId) {
		
		this.reqId = reqId;
	}


	public SRDetailsDto(Integer reqId,  RequestType requestType, Date requestedDate, Date assignedDate,
			Date committedDate, Date completedDate, Status status) {
		super();
		this.reqId = reqId;
		this.requestType = requestType;
		this.requestedDate = requestedDate;
		this.assignedDate = assignedDate;
		this.committedDate = committedDate;
		this.completedDate = completedDate;
		this.status = status;
	}


	public SRDetailsDto(Integer reqId, Location location, Integer cubicalNo, Department department, Date requiredByDate,
			RequestType requestType, String rejectionReason, String cancellationReason, Date committedDate,
			String justification, Status status) {
		super();
		this.reqId = reqId;
		this.location = location;
		this.cubicalNo = cubicalNo;
		this.department = department;
		this.requiredByDate = requiredByDate;
		this.requestType = requestType;
		this.rejectionReason = rejectionReason;
		this.cancellationReason = cancellationReason;
		this.committedDate = committedDate;
		this.justification = justification;
		this.status = status;
	}


	public SRDetailsDto(User user, Location location, Integer cubicalNo, Department department, Date requiredByDate,
			RequestType requestType, String justification, Status status) {
		super();
		this.user = user;
		this.location = location;
		this.cubicalNo = cubicalNo;
		this.department = department;
		this.requiredByDate = requiredByDate;
		this.requestType = requestType;
		this.justification = justification;
		this.status = status;
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
	 * @return the userId
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * @return the locId
	 */
	public Location getLocation() {
		return location;
	}


	/**
	 * @param locId the locId to set
	 */
	public void setLocation(Location location) {
		this.location = location;
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
	 * @return the deptId
	 */
	public Department getDepartment() {
		return department;
	}


	/**
	 * @param deptId the deptId to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
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
	 * @return the reqTypeId
	 */
	public RequestType getRequestType() {
		return requestType;
	}


	/**
	 * @param reqTypeId the reqTypeId to set
	 */
	public void setRequestType(RequestType requestType) {
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
	 * @return the requestedDate
	 */
	public Date getRequestedDate() {
		return requestedDate;
	}


	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}


	/**
	 * @return the assignedDate
	 */
	public Date getAssignedDate() {
		return assignedDate;
	}


	/**
	 * @param assignedDate the assignedDate to set
	 */
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
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
	 * @return the statusId
	 */
	public Status getStatus() {
		return status;
	}


	/**
	 * @param statusId the statusId to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SRDetailsDto [reqId=" + reqId + ", user=" + user + ", location=" + location + ", cubicalNo=" + cubicalNo
				+ ", department=" + department + ", requiredByDate=" + requiredByDate + ", requestType=" + requestType
				+ ", rejectionReason=" + rejectionReason + ", cancellationReason=" + cancellationReason
				+ ", requestedDate=" + requestedDate + ", assignedDate=" + assignedDate + ", committedDate="
				+ committedDate + ", completedDate=" + completedDate + ", justification=" + justification + ", status="
				+ status + "]";
	}


	
	
	
}
