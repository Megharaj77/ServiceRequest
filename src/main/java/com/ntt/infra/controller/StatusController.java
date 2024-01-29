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

import com.ntt.infra.dto.SRDetailsDto;
import com.ntt.infra.dto.StatusDto;
import com.ntt.infra.dto.StatusDto2;
import com.ntt.infra.service.InfraServiceException;
import com.ntt.infra.service.StatusService;

@Controller
@ComponentScan(basePackages = "com.ntt.infra")
@RequestMapping(value = "/status")
public class StatusController {

	Logger logger = LoggerFactory.getLogger(StatusController.class);

	@Autowired
	StatusService statusService;

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public String getAllStatus(Model model, @RequestBody StatusDto2 statusDto2) throws InfraControllerException {

		List<StatusDto> stsDto;
		try {
			stsDto = statusService.getStatusDetails(statusDto2);
		} catch (InfraServiceException e) {

			logger.error("Role Id " + statusDto2.getUser().getRole().getId() + " and status Id " + statusDto2.getId()
					+ " has no statuses");

			throw new InfraControllerException("Role Id " + statusDto2.getUser().getRole().getId() + " and status Id "
					+ statusDto2.getId() + " has no statuses");
		}

		model.addAttribute(stsDto);

		return "jsonTemplate";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getStatus(Model model) {

		List<StatusDto> stsDto = statusService.getstatus();

		model.addAttribute(stsDto);

		return "jsonTemplate";
	}
}
