package javabean;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String Tno;
    private String Tname;
    private String Prof;
    private String introduction;
    public Teacher(){

    }

    public Teacher(String tno, String tname, String prof, String introduction) {
        Tno = tno;
        Tname = tname;
        Prof = prof;
        this.introduction = introduction;
    }

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getProf() {
        return Prof;
    }

    public void setProf(String prof) {
        Prof = prof;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
