package com.vreddy.myretail.dao.impl;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import com.vreddy.myretail.beans.Price;
import com.vreddy.myretail.beans.PriceCount;
import com.vreddy.myretail.beans.ResponseStatus;

@Component
public class PricingDaoImpl {
	private static Cluster cluster;
	private static Session session;
	private static CassandraOperations cassandraOperations;
	private static final String node = "34.212.75.175";
	private static final Integer port = 9042;

	public static void main(String args[]) {
		connect();
	}

    private static CassandraOperations connect() {
    	session = getSession();
    	cassandraOperations = new CassandraTemplate(session);
    	return cassandraOperations;
    }

    public static Cluster getCluster(){
    	return Cluster.builder().addContactPoint(node).withCredentials("cassandra", "cassandra").withPort(port).build();
    }
    
    public static Session getSession(){
    	cluster = getCluster();
    	return cluster.connect("MyRetail");
    }

    public static Price getPricing(String item){
    	Price itemPrice = null;
    	try {
	    	if(cassandraOperations == null)
	    		cassandraOperations = connect();
	    	if(cassandraOperations == null){
	    		itemPrice = new Price();
	    		itemPrice.setError("Cassandra Operations is null");
	    		itemPrice.setResponse(ResponseStatus.FAILURE);
	    		return itemPrice;
	    	}
	    	List<Price> priceList = cassandraOperations.select("select * from myretail.pricing where item='" + item + "'", Price.class);
	    	if(priceList.size() > 0) {
	    		itemPrice = priceList.get(0);
		    	itemPrice.setResponse(ResponseStatus.SUCCESS);
	    	} else {
	    		itemPrice = new Price();
	    		itemPrice.setError("No data of " + item + " from Pricing table");
	    		itemPrice.setResponse(ResponseStatus.FAILURE);
	    	}
    	} catch(Exception ex) {
    		itemPrice.setError("Error while fetching data from Pricing table");
    		itemPrice.setResponse(ResponseStatus.FAILURE);
    		return itemPrice;
    	}
    	return itemPrice;
    }

    public static PriceCount getNumberOfItemsInPricingTable() {
    	Integer count = 0;
    	PriceCount priceCount = new PriceCount();
    	try {
	    	if(cassandraOperations == null)
	    		cassandraOperations = connect();
	    	if(cassandraOperations == null){
	    		priceCount.setError("Cassandra Operations is null");
	    		priceCount.setResponse(ResponseStatus.FAILURE);
	    		return priceCount;
	    	}
	    	count = cassandraOperations.select("select count(*) from myretail.pricing limit 1000;", Integer.class).get(0);
	    	priceCount.setCount(count);
	    	priceCount.setResponse(ResponseStatus.SUCCESS);
    	} catch(Exception ex) {
    		priceCount.setError("Error while fetching data from Pricing table");
    		priceCount.setResponse(ResponseStatus.FAILURE);
    		return priceCount;
    	}
    	return priceCount;
    }

    /*public static Price updatePricing(String item, float offer, float price){
    	Price itemPrice = null;
    	try {
	    	if(cassandraOperations == null)
	    		cassandraOperations = connect();
	    	if(cassandraOperations == null){
	    		itemPrice = new Price();
	    		itemPrice.setError("Cassandra Operations is null");
	    		itemPrice.setResponse(ResponseStatus.FAILURE);
	    		return itemPrice;
	    	}
	    	itemPrice = cassandraOperations.selectOne("select * from myretail.pricing where item='15117729'", Price.class);
	    	itemPrice.setResponse(ResponseStatus.SUCCESS);
    	} catch(Exception ex) {
    		itemPrice.setError("Error while fetching data from Pricing table");
    		itemPrice.setResponse(ResponseStatus.FAILURE);
    		return itemPrice;
    	}
    	return itemPrice;
    }*/

	public static Price updatePricingInformation(String item, Price newPrice) {
    	try {
    		QueryBuilder qb = new QueryBuilder(getCluster());
    		Insert insert = qb.insertInto("myretail", "pricing")
                    .value("item", item)
                    .value("offer", newPrice.getOffer())
                    .value("price", newPrice.getPrice());
    		//System.out.println(insert);
    		getSession().execute(insert.toString());
	    	//cassandraOperations.update("UPDATE myretail.pricing SET offer='" + newPrice.getOffer() + "' price='" + newPrice.getPrice() +"' WHERE item='" + item + "'");
	    	newPrice.setResponse(ResponseStatus.SUCCESS);
    	} catch(Exception ex) {
    		newPrice.setError("Error while fetching data from Pricing table");
    		newPrice.setResponse(ResponseStatus.FAILURE);
    	}
    	return newPrice;
	}
}