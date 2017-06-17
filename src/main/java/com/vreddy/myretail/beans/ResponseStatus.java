package com.vreddy.myretail.beans;

public enum ResponseStatus {
	SUCCESS("success"), FAILURE("failure");
	
	private String status;
	
	private ResponseStatus(String status){
		this.status = status;
	}
	
	public String toString(){
		return this.status;
	}
}