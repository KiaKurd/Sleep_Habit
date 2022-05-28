package com.example.sleephabit.model;

public class Tag {

    private int tagID;
    private String tag;


    public int getTagID() {
        return tagID;
    }
    public void setTagID(int tagID){
        this.tagID = tagID;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag){
        this.tag = tag;
    }

    @Override
    public String toString(){
        return "Tag [tagid=" + tagID + ", tag=" + tag + "]";
    }

}
