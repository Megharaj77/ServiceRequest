package com.ntt.infra.controller;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ntt.infra.dto.SRDetailsDto3;
import com.ntt.infra.dto.UserDto;
import com.ntt.infra.service.InfraServiceException;
import com.ntt.infra.service.UserService;


@Controller
@ComponentScan(basePackages = "com.ntt.infra")
@RequestMapping(value = "/request")
@CrossOrigin
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired(required=true)
	UserService userService;
	
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public String getAllUsers(Model model
			,@RequestBody UserDto userDto) throws InfraControllerException{
		
		System.out.println("In the Controller");

	  UserDto userDtoList = userService.getAllUsers(userDto);
	  
			if (userDtoList.getId() == null) {
				
				logger.error("Invalid username and password");
				
				throw new InfraControllerException("Invalid username and password");
			}else {
				model.addAttribute("userList", userDtoList);	
			}
		
			System.out.println("At last");
			System.out.println(userDtoList);

			logger.info("user details displayed");
			
		return "jsonTemplate";

	}
	
}
