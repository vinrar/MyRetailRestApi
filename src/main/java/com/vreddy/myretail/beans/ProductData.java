package com.vreddy.myretail.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductData {
	private String id;
	private float offer;
	private float price;
	private String description;
	private String url;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private String error;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
