package com.wxy.pojo;

public class Student_grade {
    private String sno;
    private String sname;
    private String ssex;
    private String sclass;
    private String gradeone;
    private String gragetwo;
    private String gradeall;
    private String susername;
    private String spassword;

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

    public String getGradeone() {
        return gradeone;
    }

    public void setGradeone(String gradeone) {
        this.gradeone = gradeone;
    }

    public String getGragetwo() {
        return gragetwo;
    }

    public void setGragetwo(String gragetwo) {
        this.gragetwo = gragetwo;
    }

    public String getGradeall() {
        return gradeall;
    }

    public void setGradeall(String gradeall) {
        this.gradeall = gradeall;
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
        return "Student_grade{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sclass='" + sclass + '\'' +
                ", gradeone='" + gradeone + '\'' +
                ", gragetwo='" + gragetwo + '\'' +
                ", gradeall='" + gradeall + '\'' +
                ", susername='" + susername + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }
}
