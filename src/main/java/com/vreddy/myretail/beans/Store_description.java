package com.vreddy.myretail.beans;
public class Store_description
{
    private String value;

    private String type;

    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}