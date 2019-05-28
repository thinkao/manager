package com.wxy.pojo;

public class Admin_notice {
    private Integer nid;
    private String context;
    private String time;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Admin_notice{" +
                "nid=" + nid +
                ", context='" + context + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
