package com.example.first_spring;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import com.example.first_spring.service.RegularUserService;
import com.example.first_spring.service.RegularUserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegularUserServiceTests {

    final RegularUserService regularUserService;

    final RegularUserDto regularUserDto;

    public RegularUserServiceTests(RegularUserService regularUserService, RegularUserDto regularUserDto) {
        this.regularUserService = regularUserService;
        this.regularUserDto = regularUserDto;
    }

    @Test
    public void createUserTest() {
        RegularUserDto fakeUser = new RegularUserDto("username123", "username123@gmail.com");
        boolean expectedResult = true;
        boolean actualResult = regularUserService.createUser(fakeUser);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getUserByUsernameTest() {
        String username = "testUser";
        RegularUser fakeUser = regularUserService.getUserByUsername(username);
        boolean expectedResult = true;
        boolean actualResult = (fakeUser != null) && fakeUser.getUsername().equals(username);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getUserByEmailTest() {
        String email = "testUser";
        RegularUser fakeUser = regularUserService.getUserByEmail(email);
        boolean expectedResult = true;
        boolean actualResult = (fakeUser != null) && fakeUser.getEmail().equals(email);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
