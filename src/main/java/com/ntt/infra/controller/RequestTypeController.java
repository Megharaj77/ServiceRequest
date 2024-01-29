package com.ntt.infra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ntt.infra.dto.RequestTypeDto;
import com.ntt.infra.dto.SRDetailsDto;
import com.ntt.infra.dto.SRDetailsDto4;
import com.ntt.infra.service.InfraServiceException;
import com.ntt.infra.service.RequestTypeService;

@Controller
@ComponentScan(basePackages = "com.ntt.infra")
@RequestMapping(value = "/requestType")
public class RequestTypeController {

	Logger logger = LoggerFactory.getLogger(RequestTypeController.class);
	
	@Autowired
	RequestTypeService requestTypeService;
	
	@RequestMapping(value = "types" , method = RequestMethod.POST)
	public String getRequestTypes(Model model, @RequestBody SRDetailsDto4 srDetailsDto4) throws InfraControllerException {
		
		List<RequestTypeDto> requestTypeDto1;
		try {
			requestTypeDto1 = requestTypeService.getRequestTypes(srDetailsDto4);
		} catch (InfraServiceException e) {
			
			logger.error("User Id " +srDetailsDto4.getUserId() + " has no requestTypes");
			throw new InfraControllerException("User Id " +srDetailsDto4.getUserId() + " has no requestTypes");
		}
		
		model.addAttribute(requestTypeDto1);
		
		return "jsonTemplate";
	}
}
