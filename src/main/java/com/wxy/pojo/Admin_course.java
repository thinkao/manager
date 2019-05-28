package com.wxy.pojo;

import java.util.ArrayList;
import java.util.List;

public class Admin_course {
    private String cno;
    private String cname;
    private String cteacher;
    private String cnumber;
    private String coursetab;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCoursetab() {
        return coursetab;
    }

    public void setCoursetab(String coursetab) {
        this.coursetab = coursetab;
    }

    @Override
    public String toString() {
        return "Admin_course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cteacher='" + cteacher + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", coursetab='" + coursetab + '\'' +
                '}';
    }
}
