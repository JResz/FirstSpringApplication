package com.example.first_spring.model;

public class HelloUser {
    private String username;
    private String email;
    private Integer ID;

    public HelloUser(String username, String email, Integer ID) {
        this.username = username;
        this.email = email;
        this.ID = ID;
    }

    public HelloUser() {
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

    public HelloUser username(String username) {
        this.username = username;
        return this;
    }

    public HelloUser email(String email) {
        this.email = email;
        return this;
    }

    public HelloUser ID(Integer ID) {
        this.ID = ID;
        return this;
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



