package com.ibm.login.entity;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_data")
public class UserData {
	
	@Id
	private String userAccountId;

	
	private String userAuthToken;
	
	private String transactionToken;
	
	@Column(name = "SERVICE_TOKEN", length = 2408)
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
