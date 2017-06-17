package com.vreddy.myretail.client;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.vreddy.myretail.beans.ProductDetails;
import com.vreddy.myretail.exception.MRException;

public class ProductDetailsClient {
	private static Client client;

	public static void main(String args[]) {
		//getProductDetails("15117729");
	}

	private static WebResource getWebResource(String requestEndpoint) {
		if (client == null) {
			client = Client.create();
			client.setConnectTimeout(1000);
			client.setReadTimeout(3000);
		}
		WebResource webResource = client.resource(requestEndpoint);
		return webResource;
	}

	public static ProductDetails getProductDetails(String itemId) {
		String result = null;
		String endPoint = "https://api.target.com/products/v3/" + itemId + "?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";
		ProductDetails response = null;
		WebResource resource = getWebResource(endPoint);
		try {
			result = resource.accept(MediaType.APPLICATION_JSON_TYPE).header(HttpHeaders.USER_AGENT, "Mozilla/5.0").get(String.class);
			response = unmarshall(result, ProductDetails.class);
		} catch (Exception e) {
			return response;
		}
		return response;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T unmarshall(String content, Class clazz) throws MRException {
		try {
			T result = (T) new ObjectMapper().readValue(content, clazz);
			return result;
		} catch (Exception e) {
			throw new MRException("Exception while unmarshalling content. " + content);
		}
	}
}