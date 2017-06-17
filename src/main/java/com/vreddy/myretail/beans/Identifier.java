package com.vreddy.myretail.beans;
public class Identifier
{
    private String id_type;

    private String id;

    private String is_primary;

    private String source;

    public void setId_type(String id_type){
        this.id_type = id_type;
    }
    public String getId_type(){
        return this.id_type;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setIs_primary(String is_primary){
        this.is_primary = is_primary;
    }
    public String getIs_primary(){
        return this.is_primary;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
}