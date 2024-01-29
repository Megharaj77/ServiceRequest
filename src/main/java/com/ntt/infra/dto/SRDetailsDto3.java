package com.ntt.infra.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ntt.infra.model.RequestType;
import com.ntt.infra.model.Status;

public class SRDetailsDto3 {

	
	private Integer reqId;
	private RequestType requestType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date requestedDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date assignedDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date committedDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date completedDate;
	private Status status;
	
	
	public SRDetailsDto3() {
		super();
	}


	public SRDetailsDto3(Integer reqId, RequestType requestType, Date requestedDate, Date assignedDate,
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
	 * @return the requestType
	 */
	public RequestType getRequestType() {
		return requestType;
	}


	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
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


	
}
