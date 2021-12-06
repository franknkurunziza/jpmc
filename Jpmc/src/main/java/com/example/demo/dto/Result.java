package com.example.demo.dto;

public class Result {
	private  String providerName;
	private Boolean isValid;
	
	public Result(String providerName, Boolean isValid) {
		super();
		this.providerName = providerName;
		this.isValid = isValid;
	}
	
	public String getProviderName() {
		return providerName;
	
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	

}
