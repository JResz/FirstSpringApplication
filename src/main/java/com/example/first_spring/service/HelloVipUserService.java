package com.example.first_spring.service;

import com.example.first_spring.model.VipUserBuilder;
import org.springframework.stereotype.Service;

@Service
public class HelloVipUserService {

    private final VipUserBuilder vipUser;

    public HelloVipUserService() {
        this.vipUser = new VipUserBuilder.Builder()
                .vipUserName("username")
                .vipUserEmail("userEmail")
                .vipUserID("userID")
                .build();
    }

    public VipUserBuilder getTestUserBuilder() {
        return this.vipUser;
    }
}

