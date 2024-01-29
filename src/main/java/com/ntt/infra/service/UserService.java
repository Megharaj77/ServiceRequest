package com.ntt.infra.service;


import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntt.infra.dto.SRDetailsDto3;
import com.ntt.infra.dto.UserDto;
import com.ntt.infra.model.SRDetails;
import com.ntt.infra.model.User;
import com.ntt.infra.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	static String me;

	public  UserDto getAllUsers(UserDto userDto) {
		
		System.out.println("In the Service layer");

		UserDto u1 = new UserDto();
		try {
		User user1 = userRepository.validateUser(userDto.getName(),userDto.getPasswd());
		u1.setId(user1.getId());
		u1.setName(user1.getName());
		u1.setPasswd(user1.getPasswd());
		u1.setRoleId(user1.getRole().getId());
		
		}catch(Exception n) {
			
			System.out.println("Invalid User:  " + n);
		}
		
		System.out.println("At object return");
		return  u1;
	
	}
	
}


