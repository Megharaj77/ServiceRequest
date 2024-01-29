package com.ntt.infra.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntt.infra.dto.SRDetailsDto;
import com.ntt.infra.dto.SRDetailsDto2;
import com.ntt.infra.dto.SRDetailsDto3;
import com.ntt.infra.dto.SRDetailsDto4;
import com.ntt.infra.model.Department;
import com.ntt.infra.model.Location;
import com.ntt.infra.model.RequestType;
import com.ntt.infra.model.SRDetails;
import com.ntt.infra.model.Status;
import com.ntt.infra.model.User;
import com.ntt.infra.repository.DepartmentRepository;
import com.ntt.infra.repository.LocationRepository;
import com.ntt.infra.repository.RequestRepository;
import com.ntt.infra.repository.RequestTypeRepository;
import com.ntt.infra.repository.StatusRepository;
import com.ntt.infra.repository.UserRepository;


@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private RequestTypeRepository requestTypeRepository;

	@Autowired
	private StatusRepository statusRepository;

	public String createNewSR(SRDetailsDto srDetailsDto) throws InfraServiceException {

		SRDetails srDetails = new SRDetails();

		User user = srDetailsDto.getUser();
		System.out.println("USER ID=====" + srDetailsDto);
		Integer userId = user.getId();
		Location loc = srDetailsDto.getLocation();
		Integer locId = loc.getLocId();
		Integer cubicalNo = srDetailsDto.getCubicalNo();
		Department dept = srDetailsDto.getDepartment();
		Integer deptId = dept.getDeptId();
		Date requiredByDate = srDetailsDto.getRequiredByDate();
		RequestType reqType = srDetailsDto.getRequestType();
		Integer reqTypeId = reqType.getId();
		String justification = srDetailsDto.getJustification();
		Status status = srDetailsDto.getStatus();
		Integer statusId = status.getId();

		String reqId1 = "";

		if (userId != null && locId != null && cubicalNo != null && deptId != null && requiredByDate != null
				&& reqTypeId != null && justification != null && statusId != null) {

			srDetails.setUser(user);
			srDetails.setLocation(loc);
			srDetails.setCubicalNo(cubicalNo);
			srDetails.setDepartment(dept);
			srDetails.setRequiredByDate(requiredByDate);
			srDetails.setRequestType(reqType);
			srDetails.setJustification(justification);
			srDetails.setStatus(status);

			if (userRepository.existsById(user.getId()) && locationRepository.existsById(loc.getLocId())
					&& departmentRepository.existsById(dept.getDeptId())
					&& requestTypeRepository.existsById(reqType.getId())
					&& statusRepository.existsById(status.getId())) {
				reqId1 = requestRepository.createSRRequest(userId, locId, cubicalNo, deptId, requiredByDate, reqTypeId,
						justification, statusId);
				System.out.println("Requestttt"+ reqId1);
			} else {
				throw new InfraServiceException("Enter valid Input");
			}

		} else {
			reqId1 = "Enter all the data";
		}

		return reqId1;
	}

	public String saveSRDetails(SRDetailsDto srDetailsDto) throws InfraServiceException {

		SRDetails srDetails = new SRDetails();
		System.out.println("Details here.................." + srDetailsDto);

		Integer reqId = srDetailsDto.getReqId();
		String rejectionReason = srDetailsDto.getRejectionReason();
		String cancellationReason = srDetailsDto.getCancellationReason();
		Date committedDate = srDetailsDto.getCommittedDate();
		String justification = srDetailsDto.getJustification();
		Status status = srDetailsDto.getStatus();
		Integer statusId = status.getId();

		String reqId1 = "";

		if (reqId != null && requestRepository.existsById(srDetailsDto.getReqId()) && rejectionReason != null
				&& cancellationReason != null && committedDate != null && justification != null && statusId != null) {

//			srDetails.setRejectionReason(rejectionReason);
//			srDetails.setCancellationReason(cancellationReason);
//			srDetails.setCommittedDate(committedDate);
//			srDetails.setJustification(justification);
//			srDetails.setStatus(status);

			reqId1 = requestRepository.updateSRRequest(reqId, rejectionReason, cancellationReason, committedDate,
					justification, statusId);
		} else {
			throw new InfraServiceException("Enter a Valid Inputs");
		}

		return reqId1;
	}

	public SRDetailsDto2 getSRDetails(SRDetailsDto2 srDetailsDto2) throws InfraServiceException {

		SRDetails srDetails = new SRDetails();

		if (requestRepository.existsById(srDetailsDto2.getReqId())) {

			srDetails = requestRepository.findRequestDetailsByReqId(srDetailsDto2.getReqId());
		} else {
			throw new InfraServiceException("Request Id " + srDetailsDto2.getReqId() + "not exists");
		}

		srDetailsDto2.setLocationName(srDetails.getLocation().getLocationName());
		srDetailsDto2.setCubicalNo(srDetails.getCubicalNo());
		srDetailsDto2.setDepartmentName(srDetails.getDepartment().getDepartmentName());
		srDetailsDto2.setRequiredByDate(srDetails.getRequiredByDate());
		srDetailsDto2.setRequestType(srDetails.getRequestType().getTypeDesc());
		srDetailsDto2.setRejectionReason(srDetails.getRejectionReason());
		srDetailsDto2.setCancellationReason(srDetails.getCancellationReason());
		srDetailsDto2.setCommittedDate(srDetails.getCommittedDate());
		srDetailsDto2.setCompletedDate(srDetails.getCompletedDate());
		srDetailsDto2.setJustification(srDetails.getJustification());
		srDetailsDto2.setStatus(srDetails.getStatus());

		System.out.println(srDetailsDto2);
		return srDetailsDto2;
	}

	public List<SRDetailsDto3> getAllRequests() {

		List<SRDetails> srDetails = new ArrayList<>();

		requestRepository.findAllRequestDetails().forEach(srDetails::add);

		List<SRDetailsDto3> srdetailsDto3 = new ArrayList<>();

		for (Iterator iterator = srDetails.iterator(); iterator.hasNext();) {

			SRDetails srDetail = (SRDetails) iterator.next();

			SRDetailsDto3 new1 = new SRDetailsDto3();

			new1.setReqId(srDetail.getReqId());
			new1.setRequestType(srDetail.getRequestType());
			new1.setRequestedDate(srDetail.getRequestedDate());
			new1.setAssignedDate(srDetail.getAssignedDate());
			new1.setCommittedDate(srDetail.getCommittedDate());
			new1.setCompletedDate(srDetail.getCompletedDate());
			new1.setStatus(srDetail.getStatus());

			srdetailsDto3.add(new1);
		}

		return srdetailsDto3;
	}

	public List<SRDetailsDto4> getRequestByCreator(SRDetailsDto4 srDetailsDto4) throws InfraServiceException {

		List<SRDetails> srDetails;

		srDetails = requestRepository.findRequestByUserId(srDetailsDto4.getUserId());

		System.out.println("User Id ::::::" + srDetailsDto4.getUserId());

		List<SRDetailsDto4> srdetailsDto = new ArrayList<>();

		if (!srDetails.isEmpty()) {

			for (Iterator iterator = srDetails.iterator(); iterator.hasNext();) {

				SRDetails srDetail = (SRDetails) iterator.next();

				SRDetailsDto4 new1 = new SRDetailsDto4();

				new1.setReqId(srDetail.getReqId());
				new1.setRequestType(srDetail.getRequestType());
				new1.setRequestedDate(srDetail.getRequestedDate());
				new1.setAssignedDate(srDetail.getAssignedDate());
				new1.setCommittedDate(srDetail.getCommittedDate());
				new1.setCompletedDate(srDetail.getCompletedDate());
				new1.setStatus(srDetail.getStatus());

				srdetailsDto.add(new1);
			}
		} else {
			throw new InfraServiceException("User Id " + srDetailsDto4.getUserId() + " not have any requests");
		}

		System.out.println(srdetailsDto);
		return srdetailsDto;
	}

}
