package com.vreddy.myretail.beans;
public class Process_status
{
    private boolean is_ready;

    private String operation_description;

    private String operation_code;

    public void setIs_ready(boolean is_ready){
        this.is_ready = is_ready;
    }
    public boolean getIs_ready(){
        return this.is_ready;
    }
    public void setOperation_description(String operation_description){
        this.operation_description = operation_description;
    }
    public String getOperation_description(){
        return this.operation_description;
    }
    public void setOperation_code(String operation_code){
        this.operation_code = operation_code;
    }
    public String getOperation_code(){
        return this.operation_code;
    }
}