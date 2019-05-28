package com.wxy.pojo;

public class Teacher {
    private String tno;
    private String tname;
    private String tphone;
    private String tprofess;
    private String tcourse;
    private String tusername;
    private String tpassword;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTprofess() {
        return tprofess;
    }

    public void setTprofess(String tprofess) {
        this.tprofess = tprofess;
    }

    public String getTcourse() {
        return tcourse;
    }

    public void setTcourse(String tcourse) {
        this.tcourse = tcourse;
    }

    public String getTusername() {
        return tusername;
    }

    public void setTusername(String tusername) {
        this.tusername = tusername;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tphone='" + tphone + '\'' +
                ", tprofess='" + tprofess + '\'' +
                ", tcourse='" + tcourse + '\'' +
                ", tusername='" + tusername + '\'' +
                ", tpassword='" + tpassword + '\'' +
                '}';
    }
}
