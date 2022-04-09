package javabean;

import java.io.Serializable;

public class Course implements Serializable {
    private int cno;
    private String cname;
    private int college;
    private String content;
    private String tno;
    public Course(){

    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Course(String cname, int college, String content, String tno) {
        this.cname = cname;
        this.college = college;
        this.content = content;
        this.tno = tno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCollege() {
        return college;
    }

    public void setCollege(int college) {
        this.college = college;
    }
}
