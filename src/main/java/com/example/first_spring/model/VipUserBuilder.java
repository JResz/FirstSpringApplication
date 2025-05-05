package com.example.first_spring.model;

public class VipUserBuilder {
    private String vipUserName;
    private String vipUserEmail;
    private String vipUserID;

    VipUserBuilder(VipUserBuilder builder) {
        this.vipUserName = builder.vipUserName;
        this.vipUserEmail = builder.vipUserEmail;
        this.vipUserID = builder.vipUserID;
    }

    public String getVipUserName() {
        return vipUserName;
    }

    public String getVipUserEmail() {
        return vipUserEmail;
    }

    public String getVipUserID() {
        return vipUserID;
    }

    public static class Builder {
        private String vipUserName;
        private String vipUserEmail;
        private String vipUserID;
    }

    public VipUserBuilder vipUserName(String vipUsername) {
        this.vipUserName = vipUsername;
        return this;
    }

    public VipUserBuilder vipUserEmail(String vipEmail) {
        this.vipUserEmail = vipEmail;
        return this;
    }

    public VipUserBuilder vipUserID(String vipID) {
        this.vipUserID = vipID;
        return this;
    }

    public VipUserBuilder build() {
        return new VipUserBuilder(this);
    }
}
