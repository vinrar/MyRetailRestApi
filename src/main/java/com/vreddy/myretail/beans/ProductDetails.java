package com.vreddy.myretail.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductDetails
{
    private Product_composite_response product_composite_response;

    public void setProduct_composite_response(Product_composite_response product_composite_response){
        this.product_composite_response = product_composite_response;
    }
    public Product_composite_response getProduct_composite_response(){
        return this.product_composite_response;
    }
    
    public ProductDetails() {}
}