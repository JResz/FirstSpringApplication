package com.example.first_spring.service;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegularUserServiceTests {

    private final RegularUserService regularUserService;

    public RegularUserServiceTests() {
        this.regularUserService = new RegularUserServiceImpl();
    }

    @Test
    void createUserTest() {
        RegularUserDto fakeUser = new RegularUserDto("username123", "username123@gmail.com");
        Assertions.assertTrue(regularUserService.createUser(fakeUser));
    }

    @Test
    void getUserByUsernameTests() {
        RegularUserDto userDto = new RegularUserDto("niggaUser2", "nigga.223@gmail.com");
        regularUserService.createUser(userDto);
        RegularUser user = regularUserService.getUserByUsername("niggaUser2");
        Assertions.assertEquals("nigga.223@gmail.com", user.getEmail());
    }

    @Test
    void getUserByEmailTest() {
        RegularUserDto userDto = new RegularUserDto("niggaUser2", "nigga.223@gmail.com");
        regularUserService.createUser(userDto);
        RegularUser user = regularUserService.getUserByEmail("nigga.223@gmail.com");
        Assertions.assertEquals("nigga.223@gmail.com", user.getEmail());
    }
}
