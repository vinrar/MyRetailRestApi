package com.vreddy.myretail.beans;

public class Price {
	private String item;
	private float offer;
	private float price;
	private String error;
	private ResponseStatus response;

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
	public String getItem() {
		return item;
	}
	public void setItem(String id) {
		this.item = id;
	}
	public float getOffer() {
		return offer;
	}
	public void setOffer(float offer) {
		this.offer = offer;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
