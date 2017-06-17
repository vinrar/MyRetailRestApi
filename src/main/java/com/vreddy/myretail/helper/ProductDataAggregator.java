package com.vreddy.myretail.helper;

import com.vreddy.myretail.beans.Price;
import com.vreddy.myretail.beans.ProductData;
import com.vreddy.myretail.beans.ProductDetails;
import com.vreddy.myretail.beans.ResponseStatus;
import com.vreddy.myretail.client.ProductDetailsClient;
import com.vreddy.myretail.dao.impl.PricingDaoImpl;

public class ProductDataAggregator {

	public static ProductData aggregateProductData(String id) {
		ProductData productData = new ProductData();
		productData.setId(id);
		try{
			ProductDetails productDetails = ProductDetailsClient.getProductDetails(id);
			
			if(productDetails != null) {
				productData.setDescription(productDetails.getProduct_composite_response().getItems().get(0).getGeneral_description());
				productData.setUrl(productDetails.getProduct_composite_response().getItems().get(0).getData_page_link());
			} else {
				productData.setError("Unable to fetch product details");
			}

			Price priceData = PricingDaoImpl.getPricing(id);

			if(priceData != null && priceData.getResponse() != ResponseStatus.FAILURE) {
				productData.setOffer(priceData.getOffer());
				productData.setPrice(priceData.getPrice());
			} else {
				String error = productData.getError();
				productData.setError(priceData.getError() + ". " + error);
			}
		} catch(Exception e) {
			productData.setError("Error while aggregating data.");
			return productData;
		}

		return productData;
	}
}