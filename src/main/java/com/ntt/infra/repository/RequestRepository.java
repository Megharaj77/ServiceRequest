package com.ntt.infra.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ntt.infra.model.SRDetails;
import com.ntt.infra.model.User;

@Repository
public interface RequestRepository extends JpaRepository<SRDetails, Integer> {

	@Procedure(name = "createSrDetails")
	String createSRRequest(@Param("arg_user_id") Integer id, @Param("arg_loc_id") Integer locId,
			@Param("arg_cubical_no") Integer cubicalNo, @Param("arg_dept_id") Integer deptId,
			@Param("arg_required_by_date") Date requiredByDate, @Param("arg_req_typeid") Integer reqTypeId,
			@Param("arg_justification") String justification, @Param("arg_status_id") Integer statusId);

	@Procedure(name = "updateSrDetails")
	String updateSRRequest(@Param("arg_req_id") Integer reqId, @Param("arg_rejection_reason") String rejectionReason,
			@Param("arg_cancellation_reason") String cancellationReason,
			@Param("arg_committed_date") Date committedDate, @Param("arg_justification") String justification,
			@Param("arg_status_id") Integer statusId);
	
	
	
	@Query("SELECT s FROM sr_details s WHERE s.reqId = ?1")
	SRDetails findRequestDetailsByReqId(Integer reqId);

	

	@Query("SELECT s FROM sr_details s")
	List<SRDetails> findAllRequestDetails();
	
	@Query("SELECT s FROM sr_details s WHERE s.user.id=?1")
	List<SRDetails> findRequestByUserId(Integer userId);

}

