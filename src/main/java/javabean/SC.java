package javabean;

import java.io.Serializable;

public class SC implements Serializable {
    private String sno;
    private int cno;
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public SC(){

    }

    public SC(String sno, int cno, String cname) {
        this.sno = sno;
        this.cno = cno;
        this.cname = cname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }
}
