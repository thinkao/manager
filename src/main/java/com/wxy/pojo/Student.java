package com.wxy.pojo;

import com.wxy.pojo.base.BaseBean;

public class Student extends BaseBean {
    private String sno;
    private String sname;
    private String ssex;
    private String sclass;
    private String susername;
    private String spassword;
    private String gradeone;
    private String gradetwo;
    private String gradeall;
    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getGradeone() {
        return gradeone;
    }

    public void setGradeone(String gradeone) {
        this.gradeone = gradeone;
    }

    public String getGradetwo() {
        return gradetwo;
    }

    public void setGradetwo(String gradetwo) {
        this.gradetwo = gradetwo;
    }

    public String getGradeall() {
        return gradeall;
    }

    public void setGradeall(String gradeall) {
        this.gradeall = gradeall;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sclass='" + sclass + '\'' +
                ", susername='" + susername + '\'' +
                ", spassword='" + spassword + '\'' +
                ", gradeone='" + gradeone + '\'' +
                ", gradetwo='" + gradetwo + '\'' +
                ", gradeall='" + gradeall + '\'' +
                ", object='" + object + '\'' +
                '}';
    }
}
