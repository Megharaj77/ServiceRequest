package com.ntt.infra.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntt.infra.dto.RequestTypeDto;

import com.ntt.infra.dto.SRDetailsDto4;
import com.ntt.infra.model.RequestType;
import com.ntt.infra.repository.RequestRepository;
import com.ntt.infra.repository.RequestTypeRepository;


@Service
public class RequestTypeService {

	@Autowired
	RequestTypeRepository requestTypeRepository;
	
	@Autowired
	RequestRepository requestRepository;
	
	
	public List<RequestTypeDto> getRequestTypes(SRDetailsDto4 srDetailsDto4) throws InfraServiceException {
		
		
		List<RequestType> requestType;
		
		
			requestType= requestTypeRepository.findRequestByUser(srDetailsDto4.getUserId());
		
		List<RequestTypeDto> requestTypeDto1 = new ArrayList<>();
		
		if(!requestType.isEmpty()) {
			
			for(Iterator iterator = requestType.iterator(); iterator.hasNext();) {
				
				RequestType requestTypes = (RequestType) iterator.next();
				
				RequestTypeDto new1 = new RequestTypeDto();
				
				new1.setId(requestTypes.getId());
				new1.setTypedesc(requestTypes.getTypeDesc());
				
				
				requestTypeDto1.add(new1);
			}
			
		}else {
			throw new InfraServiceException("User Id " + srDetailsDto4.getUserId() + " not have any requests Types");
		}
		
		
		return requestTypeDto1;
	}
}
