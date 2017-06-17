package com.vreddy.myretail.beans;
import java.util.List;
public class Items
{
    private List<Identifier> identifier;

    private String relation;

    private String relation_description;

    private String data_page_link;

    private int imn_identifier;

    private String parent_id;

    private boolean is_orderable;

    private boolean is_sellable;

    private String general_description;

    private boolean is_circular_publish;

    private List<Business_process_status> business_process_status;

    private String dpci;

    private int department_id;

    private int class_id;

    private int item_id;

    private Online_description online_description;

    private Store_description store_description;

    private List<Alternate_description> alternate_description;

    private List<Features> features;

    public void setIdentifier(List<Identifier> identifier){
        this.identifier = identifier;
    }
    public List<Identifier> getIdentifier(){
        return this.identifier;
    }
    public void setRelation(String relation){
        this.relation = relation;
    }
    public String getRelation(){
        return this.relation;
    }
    public void setRelation_description(String relation_description){
        this.relation_description = relation_description;
    }
    public String getRelation_description(){
        return this.relation_description;
    }
    public void setData_page_link(String data_page_link){
        this.data_page_link = data_page_link;
    }
    public String getData_page_link(){
        return this.data_page_link;
    }
    public void setImn_identifier(int imn_identifier){
        this.imn_identifier = imn_identifier;
    }
    public int getImn_identifier(){
        return this.imn_identifier;
    }
    public void setParent_id(String parent_id){
        this.parent_id = parent_id;
    }
    public String getParent_id(){
        return this.parent_id;
    }
    public void setIs_orderable(boolean is_orderable){
        this.is_orderable = is_orderable;
    }
    public boolean getIs_orderable(){
        return this.is_orderable;
    }
    public void setIs_sellable(boolean is_sellable){
        this.is_sellable = is_sellable;
    }
    public boolean getIs_sellable(){
        return this.is_sellable;
    }
    public void setGeneral_description(String general_description){
        this.general_description = general_description;
    }
    public String getGeneral_description(){
        return this.general_description;
    }
    public void setIs_circular_publish(boolean is_circular_publish){
        this.is_circular_publish = is_circular_publish;
    }
    public boolean getIs_circular_publish(){
        return this.is_circular_publish;
    }
    public void setBusiness_process_status(List<Business_process_status> business_process_status){
        this.business_process_status = business_process_status;
    }
    public List<Business_process_status> getBusiness_process_status(){
        return this.business_process_status;
    }
    public void setDpci(String dpci){
        this.dpci = dpci;
    }
    public String getDpci(){
        return this.dpci;
    }
    public void setDepartment_id(int department_id){
        this.department_id = department_id;
    }
    public int getDepartment_id(){
        return this.department_id;
    }
    public void setClass_id(int class_id){
        this.class_id = class_id;
    }
    public int getClass_id(){
        return this.class_id;
    }
    public void setItem_id(int item_id){
        this.item_id = item_id;
    }
    public int getItem_id(){
        return this.item_id;
    }
    public void setOnline_description(Online_description online_description){
        this.online_description = online_description;
    }
    public Online_description getOnline_description(){
        return this.online_description;
    }
    public void setStore_description(Store_description store_description){
        this.store_description = store_description;
    }
    public Store_description getStore_description(){
        return this.store_description;
    }
    public void setAlternate_description(List<Alternate_description> alternate_description){
        this.alternate_description = alternate_description;
    }
    public List<Alternate_description> getAlternate_description(){
        return this.alternate_description;
    }
    public void setFeatures(List<Features> features){
        this.features = features;
    }
    public List<Features> getFeatures(){
        return this.features;
    }
}