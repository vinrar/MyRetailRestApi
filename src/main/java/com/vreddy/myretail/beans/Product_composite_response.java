package com.vreddy.myretail.beans;
import java.util.List;

public class Product_composite_response
{
    private List<Request_attributes> request_attributes;

    private List<Items> items;

    public void setRequest_attributes(List<Request_attributes> request_attributes){
        this.request_attributes = request_attributes;
    }
    public List<Request_attributes> getRequest_attributes(){
        return this.request_attributes;
    }
    public void setItems(List<Items> items){
        this.items = items;
    }
    public List<Items> getItems(){
        return this.items;
    }
}