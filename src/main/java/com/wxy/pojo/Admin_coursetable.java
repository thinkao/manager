package com.wxy.pojo;

public class Admin_coursetable {
    private String cno;
    private String ttime;
    private String taddress;
    private String troom;
    private String tteacher;
    private String tstudent;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTroom() {
        return troom;
    }

    public void setTroom(String troom) {
        this.troom = troom;
    }

    public String getTteacher() {
        return tteacher;
    }

    public void setTteacher(String tteacher) {
        this.tteacher = tteacher;
    }

    public String getTstudent() {
        return tstudent;
    }

    public void setTstudent(String tstudent) {
        this.tstudent = tstudent;
    }

    @Override
    public String toString() {
        return "Admin_coursetable{" +
                "ttime='" + ttime + '\'' +
                ", taddress='" + taddress + '\'' +
                ", troom='" + troom + '\'' +
                ", tteacher='" + tteacher + '\'' +
                ", tstudent='" + tstudent + '\'' +
                '}';
    }
}
