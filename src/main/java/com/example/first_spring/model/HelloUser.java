package com.example.first_spring.model;

import java.util.ArrayList;
import java.util.List;

public class HelloUser {
    private String username;
    private String email;
    private Integer ID;

    public HelloUser(String username, String email, Integer ID) {
        this.username = username;
        this.email = email;
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Integer getID() {
        return ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}



