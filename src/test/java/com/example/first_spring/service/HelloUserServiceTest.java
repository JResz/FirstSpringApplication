package com.example.first_spring.service;
import com.example.first_spring.dto.UserDto;
import com.example.first_spring.model.HelloUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class HelloUserServiceTest {

    private HelloUserService helloUserService;

    public HelloUserServiceTest(){
        this.helloUserService = new HelloUserService();
    }

    @Test
    void createUserByIdTest() {
        UserDto userDto = new UserDto("niggaUser", "nigga.123@gmail.com", 4686);
        helloUserService.createUser(userDto);
        HelloUser user = helloUserService.getUserById(4686);
        Assertions.assertEquals("niggaUser",user.getUsername());
    }

    @Test
    void getUserByIdTest() {
        UserDto userDto = new UserDto("niggaUser", "nigga.123@gmail.com", 4686);
        helloUserService.createUser(userDto);
        HelloUser user = helloUserService.getUserById(4686);
        Assertions.assertNotNull(user, "User should exist");
        Assertions.assertEquals("niggaUser",user.getUsername());
    }

}
