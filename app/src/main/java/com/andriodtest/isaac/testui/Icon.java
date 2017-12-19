package com.andriodtest.isaac.testui;

/**
 * Created by isaac on 2017/11/6.
 */

public class Icon {
    private int iId;
    private String iName;

    public Icon(){}
    public Icon(int iId,String iName){
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
