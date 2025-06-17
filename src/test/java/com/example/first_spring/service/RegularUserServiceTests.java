package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RegularUserServiceTests {

    @Autowired
    private RegularUserService regularUserService;

    @BeforeEach
    void setUp() {
        RegularUserDto user1 = new RegularUserDto("user1", "user1@gmail.com");
        RegularUserDto user2 = new RegularUserDto("user2", "user2@gmail.com");
        RegularUserDto user3 = new RegularUserDto("user3", "user3@gmail.com");

        regularUserService.createUser(user1);
        regularUserService.createUser(user2);
        regularUserService.createUser(user3);
    }

    @AfterEach
    void tearDown() {
        regularUserService.clearAll();
    }

    @Test
    void changeUsernameTest() {
        ChangeUsernameDto changeUsernameDto = new ChangeUsernameDto("user1@gmail.com", "changedUsername");
        RegularUser changedUser = regularUserService.changeUsernameByEmail(changeUsernameDto);

        assertEquals("changedUsername", changedUser.getUsername());
        assertEquals("user1@gmail.com", changedUser.getEmail());
    }

    @Test
    void changeEmailTest() {
        ChangeUserEmailDto changeUserEmailDto = new ChangeUserEmailDto("user2", "newEmail");
        RegularUser changedUser = regularUserService.changeUserEmailByUsername(changeUserEmailDto);

        assertEquals("user2", changedUser.getUsername());
        assertEquals("newEmail", changedUser.getEmail());
    }

    @Test
    void createUserTest() {
        RegularUserDto fakeUser = new RegularUserDto("username123", "username123@gmail.com");
        assertTrue(regularUserService.createUser(fakeUser));
    }

    @Test
    void getUserByUsernameTests() {
        RegularUser user = regularUserService.getUserByUsername("user3");
        assertEquals("user3@gmail.com", user.getEmail());
    }

    @Test
    void getUserByEmailTest() {
        RegularUser user = regularUserService.getUserByEmail("user3@gmail.com");
        assertEquals("user3@gmail.com", user.getEmail());
    }

    @Test
    void getAllRegularUsersTest() {
        List<RegularUser> users = regularUserService.getAllRegularUsers();
        assertEquals(3, users.size());
    }
}
