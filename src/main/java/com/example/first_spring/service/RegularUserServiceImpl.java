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
        - First check if the current test cases works correct
        and check the controller layer on POSTMAN
        - Create suitable Interface for RegularUserServiceImpl
        - Get all users
        - Get user by email
        - Change username
        - Create test cases for each method
        - Create controller for each method

        Run all new test cases and check all controllers
        on POSTMAN

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
}







