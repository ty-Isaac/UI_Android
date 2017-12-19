package com.andriodtest.isaac.testui.ListVIew;

/**
 * Created by isaac on 2017/11/6.
 */

public class Celebrity {
    private String CeleName;
    private String Dictum;
    private int Icon;

    public Celebrity(String name,String dictum,int Icon){
        this.CeleName = name;
        this.Dictum = dictum;
        this.Icon = Icon;
    }

    public String getCeleName() {
        return CeleName;
    }

    public void setCeleName(String celeName) {
        CeleName = celeName;
    }

    public String getDictum() {
        return Dictum;
    }

    public void setDictum(String dictum) {
        Dictum = dictum;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }
}
