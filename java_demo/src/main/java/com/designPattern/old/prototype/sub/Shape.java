package com.designPattern.old.prototype.sub;

/**
 * Created by Brian in 23:06 2018/5/1
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    protected abstract void draw();

    public Object clone(){
        Object objCopy = null;

        try {
            objCopy = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return objCopy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
