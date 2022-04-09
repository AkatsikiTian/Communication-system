package javabean;

import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private String Name;
    private String position;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    public Account(String username, String password, String position,String Name) {
        this.username = username;
        this.password = password;
        this.position = position;
        this.Name = Name;
    }

    public Account(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
