package com.wxy.pojo;

public class Admin_room {
    private String rno;
    private String rnumber;
    private String rcomputer;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getRnumber() {
        return rnumber;
    }

    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
    }

    public String getRcomputer() {
        return rcomputer;
    }

    public void setRcomputer(String rcomputer) {
        this.rcomputer = rcomputer;
    }

    @Override
    public String toString() {
        return "Admin_room{" +
                "rno='" + rno + '\'' +
                ", rnumber='" + rnumber + '\'' +
                ", rcomputer='" + rcomputer + '\'' +
                '}';
    }
}
