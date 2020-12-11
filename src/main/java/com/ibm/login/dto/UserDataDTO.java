package com.ibm.login.dto;

public class UserDataDTO {
	
	private String userAccountId;
	
	private String userAuthToken;
	
	private String transactionToken;
	
	private String serviceToken;
	
	public String getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getUserAuthToken() {
		return userAuthToken;
	}
	public void setUserAuthToken(String userAuthToken) {
		this.userAuthToken = userAuthToken;
	}
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	public String getServiceToken() {
		return serviceToken;
	}
	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}
}
