package com.vreddy.myretail.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vreddy.myretail.beans.Price;
import com.vreddy.myretail.beans.ProductData;
import com.vreddy.myretail.beans.ProductDetails;
import com.vreddy.myretail.dao.impl.PricingDaoImpl;
import com.vreddy.myretail.helper.ProductDataAggregator;

@Path("")
public class ProductService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProductsCount() {
		return "We have " + PricingDaoImpl.getNumberOfItemsInPricingTable().getCount() + " products in our pricing catalogue";
	}

	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductData getProduct(@PathParam(value = "productId") String id) {
		return ProductDataAggregator.aggregateProductData(id);
	}

	@PUT
	@Path("/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Price updatePrice(@PathParam(value = "productId") String id, Price newPrice) {
		return PricingDaoImpl.updatePricingInformation(id, newPrice);
	}
}