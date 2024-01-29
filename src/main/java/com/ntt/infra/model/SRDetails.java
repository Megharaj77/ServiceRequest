package com.ntt.infra.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "sr_details")

@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "createSrDetails", procedureName = "p_create_sr", parameters = {
				@StoredProcedureParameter(name = "arg_user_id", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_loc_id", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_cubical_no", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_dept_id", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_required_by_date", type = Date.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_req_typeid", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_justification", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_status_id", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_req_id", type = String.class, mode = ParameterMode.OUT) }),

		@NamedStoredProcedureQuery(name = "updateSrDetails", procedureName = "p_update_sr", parameters = {
				@StoredProcedureParameter(name = "arg_req_id", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_rejection_reason", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_cancellation_reason", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_committed_date", type = Date.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_justification", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "arg_status_id", type = Integer.class, mode = ParameterMode.IN) })

})

public class SRDetails implements Serializable {

	public static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQ_ID")
	private Integer reqId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "LOC_ID", referencedColumnName = "LOC_ID")
	private Location location;

	@Column(name = "CUBICAL_NO")
	private Integer cubicalNo;

	@ManyToOne
	@JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
	private Department department;

	@Column(name = "REQUIRED_BY_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date requiredByDate;

	@ManyToOne
	@JoinColumn(name = "REQ_TYPEID", referencedColumnName = "ID")
	private RequestType requestType;

	@Column(name = "REJECTION_REASON")
	private String rejectionReason;

	@Column(name = "CANCELLATION_REASON")
	private String cancellationReason;

	@Column(name = "REQUESTED_DATE")
	private Date requestedDate;

	@Column(name = "ASSIGNED_DATE")
	private Date assignedDate;

	@Column(name = "COMMITTED_DATE")
	private Date committedDate;

	@Column(name = "COMPLETED_DATE")
	private Date completedDate;

	@Column(name = "JUSTIFICATION")
	private String justification;

	@ManyToOne
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
	private Status status;

	public SRDetails() {

	}

	public SRDetails(User user, Location location, Integer cubicalNo, Department department, Date requiredByDate,
			RequestType requestType, String rejectionReason, String cancellationReason, Date requestedDate,
			Date assignedDate, Date committedDate, Date completedDate, String justification, Status status) {
		super();
		this.user = user;
		this.location = location;
		this.cubicalNo = cubicalNo;
		this.department = department;
		this.requiredByDate = requiredByDate;
		this.requestType = requestType;
		this.rejectionReason = rejectionReason;
		this.cancellationReason = cancellationReason;
		this.requestedDate = requestedDate;
		this.assignedDate = assignedDate;
		this.committedDate = committedDate;
		this.completedDate = completedDate;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
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
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
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

	@Override
	public String toString() {
		return "SRDetails [reqId=" + reqId + ", user=" + user + ", location=" + location + ", cubicalNo=" + cubicalNo
				+ ", department=" + department + ", requiredByDate=" + requiredByDate + ", requestType=" + requestType
				+ ", rejectionReason=" + rejectionReason + ", cancellationReason=" + cancellationReason
				+ ", requestedDate=" + requestedDate + ", assignedDate=" + assignedDate + ", committedDate="
				+ committedDate + ", completedDate=" + completedDate + ", justification=" + justification + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedDate, cancellationReason, committedDate, completedDate, cubicalNo, department,
				justification, location, rejectionReason, reqId, requestType, requestedDate, requiredByDate, status,
				user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SRDetails)) {
			return false;
		}
		SRDetails other = (SRDetails) obj;
		return Objects.equals(assignedDate, other.assignedDate)
				&& Objects.equals(cancellationReason, other.cancellationReason)
				&& Objects.equals(committedDate, other.committedDate)
				&& Objects.equals(completedDate, other.completedDate) && Objects.equals(cubicalNo, other.cubicalNo)
				&& Objects.equals(department, other.department) && Objects.equals(justification, other.justification)
				&& Objects.equals(location, other.location) && Objects.equals(rejectionReason, other.rejectionReason)
				&& Objects.equals(reqId, other.reqId) && Objects.equals(requestType, other.requestType)
				&& Objects.equals(requestedDate, other.requestedDate)
				&& Objects.equals(requiredByDate, other.requiredByDate) && Objects.equals(status, other.status)
				&& Objects.equals(user, other.user);
	}

}
