package com.example.first_spring.service;

import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegularUserServiceTest {

    private RegularUserServiceImpl helloUserService;

    public RegularUserServiceTest() {
        this.helloUserService = new RegularUserServiceImpl();
    }

    @Test
    void createUserTest() {
        RegularUserDto userDto = new RegularUserDto("niggaUser", "nigga.123@gmail.com");
        helloUserService.createUser(userDto);
        RegularUser user = helloUserService.getUserByUsername("niggaUser");
        Assertions.assertEquals("nigga.123@gmail.com", user.getEmail());
    }

    @Test
    void getUserByUsernameTest() {
        RegularUserDto userDto = new RegularUserDto("niggaUser2", "nigga.223@gmail.com");
        helloUserService.createUser(userDto);
        RegularUser user = helloUserService.getUserByUsername("niggaUser2");
        Assertions.assertEquals("nigga.223@gmail.com", user.getEmail());
    }
}
