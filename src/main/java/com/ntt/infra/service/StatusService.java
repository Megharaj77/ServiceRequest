package com.ntt.infra.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntt.infra.dto.RequestTypeDto;
import com.ntt.infra.dto.SRDetailsDto;
import com.ntt.infra.dto.StatusDto;
import com.ntt.infra.dto.StatusDto2;
import com.ntt.infra.model.RequestType;
import com.ntt.infra.model.Status;
import com.ntt.infra.repository.StatusRepository;


@Service
public class StatusService {

	@Autowired
	StatusRepository statusrepository;

	public List<StatusDto> getStatusDetails(StatusDto2 statusDto2) throws InfraServiceException {

		List<Status> status;

		status = statusrepository.findAllStatus(statusDto2.getUser().getRole().getId(), statusDto2.getId());
		List<StatusDto> statusDto1 = new ArrayList<>();

		if (!status.isEmpty()) {

			for (Iterator iterator = status.iterator(); iterator.hasNext();) {

				Status sts = (Status) iterator.next();

				StatusDto new1 = new StatusDto();

				new1.setId(sts.getId());
				new1.setStsdesc(sts.getStsDesc());

				statusDto1.add(new1);
			}

		} else {
			throw new InfraServiceException("Role Id " + statusDto2.getUser().getRole().getId() + " and status Id "
					+ statusDto2.getId() + "has no statuses");
		}

		return statusDto1;
	}

	public List<StatusDto> getstatus() {

		List<Status> sts = statusrepository.findStatus();

		List<StatusDto> statusDto1 = new ArrayList<>();

		for (Iterator iterator = sts.iterator(); iterator.hasNext();) {

			Status status = (Status) iterator.next();

			StatusDto new1 = new StatusDto();

			new1.setId(status.getId());
			new1.setStsdesc(status.getStsDesc());

			statusDto1.add(new1);
		}

		return statusDto1;
	}
}
