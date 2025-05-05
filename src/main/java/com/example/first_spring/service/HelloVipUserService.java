package com.example.first_spring.service;
import com.example.first_spring.model.VipUserBuilder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloVipUserService {
    private final List<VipUserBuilder> vipUsers;

    public HelloVipUserService() {
        vipUsers = new ArrayList<>();
        }

    public VipUserBuilder createUser = new VipUserBuilder.Builder()
                .vipUsername("username")
                .vipUserEmail("userEmail")
                .vipUserID("userID")
                .build();
    } ///// chuj siedzialem dlugo nad tym nie wiem czemu .vipusername nie ma wstrzykniecia danych i nie wykrywa
//////że jest już metoda ktora zawiera username, tak samo email i ID

