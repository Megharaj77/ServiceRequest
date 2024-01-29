package com.ntt.infra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ntt.infra.dto.SRDetailsDto;
import com.ntt.infra.dto.SRDetailsDto2;
import com.ntt.infra.dto.SRDetailsDto3;
import com.ntt.infra.dto.SRDetailsDto4;
import com.ntt.infra.service.InfraServiceException;
import com.ntt.infra.service.RequestService;

@Controller
@ComponentScan(basePackages = "com.ntt.infra")
@RequestMapping(value = "/create")
@CrossOrigin
public class RequestController {

	Logger logger = LoggerFactory.getLogger(RequestController.class);

	@Autowired(required = true)
	private RequestService requestService;

	@RequestMapping(value = "/sr", method = RequestMethod.POST)
	public String addServiceRequest(Model model, @RequestBody SRDetailsDto srDetailsDto)
			throws InfraControllerException {

		String reqId;
		try {
			reqId = requestService.createNewSR(srDetailsDto);
		} catch (InfraServiceException e) {
			
			logger.error("User provided the invalid input");
			throw new InfraControllerException("Invalid Input");

		}

		
		model.addAttribute("Request ID: " + reqId);
		
		return "jsonTemplate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateSrRequest(Model model, @RequestBody SRDetailsDto srDetailsDto) throws InfraControllerException {

		
		String reqId1;
		try {
			reqId1 = requestService.saveSRDetails(srDetailsDto);
		} catch (InfraServiceException e) {

			logger.error("Updation Unsuccessfull!!!.Enter all fields with valid inputs");
			throw new InfraControllerException("Updation Unsuccessfull!!!.Enter all fields with valid inputs");
		}

		model.addAttribute(reqId1);

		return "jsonTemplate";
	}

	@RequestMapping(value = "/getRequests", method = RequestMethod.POST)
	public String getRequests(Model model, @RequestBody SRDetailsDto2 srDetailsDto2) throws InfraControllerException {

		SRDetailsDto2 srDetailsDto1;
		try {
			srDetailsDto1 = requestService.getSRDetails(srDetailsDto2);
		} catch (InfraServiceException e) {
			
			logger.error("Request Id " + srDetailsDto2.getReqId() + " not exists");
			throw new InfraControllerException("Request Id " + srDetailsDto2.getReqId() + " not exists");
		}

		model.addAttribute(srDetailsDto1);

		return "jsonTemplate";
	}

	@RequestMapping(value = "/AllRequests", method = RequestMethod.GET)
	public String allRequests(Model model) {

		List<SRDetailsDto3> srDetailsDto3 = requestService.getAllRequests();

		model.addAttribute(srDetailsDto3);

		
		return "jsonTemplate";
	}

	@RequestMapping(value = "/RequestByUser", method = RequestMethod.POST)
	public String getRequestByUser(Model model, @RequestBody SRDetailsDto4 srDetailsDto4)
			throws InfraServiceException, InfraControllerException {

		List<SRDetailsDto4> srDetailsDto;
		try {
			srDetailsDto = requestService.getRequestByCreator(srDetailsDto4);
		} catch (InfraServiceException e) {
			
			logger.error("User Id " + srDetailsDto4.getUserId() + " has no requests");
			throw new InfraControllerException("User Id " + srDetailsDto4.getUserId() + " has no requests");
		}

		model.addAttribute(srDetailsDto);

		return "jsonTemplate";
	}


}
