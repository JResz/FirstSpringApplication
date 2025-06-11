package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RegularUserServiceTests {

    @Autowired
    private RegularUserService regularUserService;

    @Test
    void changeUsernameTest() {
        RegularUserDto userDto = new RegularUserDto("testUser", "test@gmail.com");
        regularUserService.createUser(userDto);

        ChangeUsernameDto changeUsernameDto = new ChangeUsernameDto("test@gmail.com", "changedUser");
        RegularUser changedUser = regularUserService.changeUsername(changeUsernameDto);

        assertEquals("changedUser", changedUser.getUsername());
        assertEquals("test@gmail.com", changedUser.getEmail());
    }

    @Test
    void createUserTest() {
        RegularUserDto fakeUser = new RegularUserDto("username123", "username123@gmail.com");
        assertTrue(regularUserService.createUser(fakeUser));
    }

    @Test
    void getUserByUsernameTests() {
        RegularUserDto userDto = new RegularUserDto("niggaUser2", "nigga.223@gmail.com");
        regularUserService.createUser(userDto);
        RegularUser user = regularUserService.getUserByUsername("niggaUser2");
        assertEquals("nigga.223@gmail.com", user.getEmail());
    }

    @Test
    void getUserByEmailTest() {
        RegularUserDto userDto = new RegularUserDto("niggaUser2", "nigga.223@gmail.com");
        regularUserService.createUser(userDto);
        RegularUser user = regularUserService.getUserByEmail("nigga.223@gmail.com");
        assertEquals("nigga.223@gmail.com", user.getEmail());
    }
}
