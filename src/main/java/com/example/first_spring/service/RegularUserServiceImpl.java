package com.example.first_spring.service;

import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegularUserServiceImpl implements RegularUserService {
    /*
        TODO:
        - Fix change username
        - Create change email
        - Create test cases for each method
        - Create controller for each method
        - Check if the current test cases works correct
        and check the controller layer on POSTMAN

        Additional:
        - Do not allow duplicate email and username during createUser
    */

    private final List<RegularUser> users;

    public RegularUserServiceImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public boolean createUser(RegularUserDto userDto) {
        RegularUser regularUser = new RegularUser.Builder()
                .username(userDto.username())
                .email(userDto.email())
                .build();

        return users.add(regularUser);
    }

    @Override
    public RegularUser getUserByUsername(String username) {
        for (RegularUser user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<RegularUser> getAllRegularUsers() {
        return users;
    }

    @Override
    public RegularUser getUserByEmail(String email) {
        for (RegularUser user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }


    /*
    Good idea, but as you can see, you're finding the username
    by existing username and setting the same username again ;).

    Also, keep in mind that using, a public method inside another
    public method can lea to issues when using inheritance.
    If someone overrides getUserByUsername in a subclass, it
    may break the behavior of changeUsername.

    I recommend to extracting a private method for the actual lookup logic.
    Then you can safely use that method inside getUserByUsername and changeUsername.
    */
    @Override
    public RegularUser changeUsername(RegularUserDto userDto) {
        RegularUser user = getUserByUsername(userDto.username());
        if (user == null) {
            return null;
        }
        user.setUsername(userDto.username());
        return user;
    }
}







