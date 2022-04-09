package javabean;

import java.io.Serializable;

public class Student implements Serializable {
    private String Name;
    private String Sno;
    public Student(){

    }

    public Student(String sno, String name) {
        Name = name;
        Sno = sno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }
}
