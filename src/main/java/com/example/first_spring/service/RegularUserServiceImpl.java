package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegularUserServiceImpl implements RegularUserService {
    /*
        TODO:
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
        return getUser(email);
    }

    private RegularUser getUser(String email) {
        for (RegularUser user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public RegularUser changeUsername(ChangeUsernameDto changeUsernameDto) {
        RegularUser user = getUser(changeUsernameDto.email());
        if (user == null) {
            return null;
        }
        user.setUsername(changeUsernameDto.newUsername());
        return user;
    }

    @Override
    public RegularUser changeUserEmail(ChangeUserEmailDto changeUserEmailDto) {
        RegularUser user = getUserByEmail(changeUserEmailDto.username());
        if (user == null) {
            return null;
        }
        user.setEmail(changeUserEmailDto.newEmail());
        return user;
    }
}