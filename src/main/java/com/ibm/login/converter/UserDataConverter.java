package com.ibm.login.converter;

import com.ibm.login.dto.UserDataDTO;
import com.ibm.login.entity.UserData;

public class UserDataConverter {
	
public UserData convertToEntity(UserDataDTO dto) {
		
		UserData userData = new UserData();
		
		userData.setServiceToken(dto.getServiceToken());
		userData.setTransactionToken(dto.getTransactionToken());
		userData.setUserAccountId(dto.getUserAccountId());
		userData.setUserAuthToken(dto.getUserAuthToken());
		
		return userData;
	}
	
	public UserDataDTO convertToDTO(UserData entity) {
		
		UserDataDTO userDataDTO = new UserDataDTO();
	
		userDataDTO.setServiceToken(entity.getServiceToken());
		userDataDTO.setTransactionToken(entity.getTransactionToken());
		userDataDTO.setUserAccountId(entity.getUserAccountId());
		userDataDTO.setUserAuthToken(entity.getUserAuthToken());
		
		return userDataDTO;
	}


}
