package com.example.sleephabit.model;

public class TipsDescription {

    private int tdID;
    private String description;

    public int getTDid(){
        return tdID;
    }
    public void setTDid(int TDid){
        this.tdID = TDid;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String describe){
        this.description = describe;
    }

    @Override
    public String toString(){
        return "TipsDescription{" + "tdid=" + tdID + '\'' + ", describe='" + description + '\'' + '}';
    }
}
