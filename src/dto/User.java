package dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String ini;
    private String roles;
    private String password;
    private String cpr;

    public User() {
    }

    public User(int id, String name, String ini, String roles, String password, String cpr) {
        this.id = id;
        this.name = name;
        this.ini = ini;
        this.roles = roles;
        this.password = password;
        this.cpr = cpr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIni() {
        return ini;
    }

    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getCpr() {
        return cpr;
    }
}

