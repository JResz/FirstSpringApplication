package com.example.first_spring;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import com.example.first_spring.service.RegularUserService;
import com.example.first_spring.service.RegularUserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

// Should remove public
public class RegularUserServiceTests {

    // Keyword private is more important than final in this case
    // I see final but don't see private
    final RegularUserService regularUserService;

    // Why if you are creating separated instances in each class
    // final RegularUserDto regularUserDto;

    public RegularUserServiceTests(RegularUserService regularUserService) {
        // It is the issue why service not working in the test
        // you need to create the new instance or use @Autowired
        // without it the object not exists.
        // Even if it would be the correct solution you provided as an argument the
        // interface that doesn't have any implementations
        this.regularUserService = regularUserService;
    }

    // We need to use assertTrue
    @Test
    @Disabled
    public void createUserTest() {
        RegularUserDto fakeUser = new RegularUserDto("username123", "username123@gmail.com");
        boolean expectedResult = true;
        boolean actualResult = regularUserService.createUser(fakeUser);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Disabled
    public void getUserByUsernameTest() {
        String username = "testUser";
        RegularUser fakeUser = regularUserService.getUserByUsername(username);
        boolean expectedResult = true;
        boolean actualResult = (fakeUser != null) && fakeUser.getUsername().equals(username);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Disabled
    public void getUserByEmailTest() {
        String email = "testUser";
        RegularUser fakeUser = regularUserService.getUserByEmail(email);
        boolean expectedResult = true;
        boolean actualResult = (fakeUser != null) && fakeUser.getEmail().equals(email);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
