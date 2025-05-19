package com.example.first_spring.model;

public class RegularUser {

    private String username;
    private String email;

    public RegularUser(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
    }

    public void setUsername(String username) { this.username = username;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {

        private String username;
        private String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public RegularUser build() {
            return new RegularUser(this);
        }
    }
}



