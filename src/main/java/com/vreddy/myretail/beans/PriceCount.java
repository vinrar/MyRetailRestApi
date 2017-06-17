package com.vreddy.myretail.beans;

public class PriceCount {
	private Integer count;
	private String error;
	private ResponseStatus response;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public ResponseStatus getResponse() {
		return response;
	}
	public void setResponse(ResponseStatus response) {
		this.response = response;
	}
}