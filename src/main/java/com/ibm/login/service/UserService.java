package com.ibm.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.login.converter.UserDataConverter;
import com.ibm.login.dto.UserDataDTO;
import com.ibm.login.entity.UserData;
import com.ibm.login.repository.UserDataRepository;

@Service
public class UserService {
	
	@Autowired
	public UserDataRepository userDataRepo;

	public UserData createUserData(UserDataDTO dto) {

		UserDataConverter converter=new UserDataConverter();


		return userDataRepo.save(converter.convertToEntity(dto));

	}



}
