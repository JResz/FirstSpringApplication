package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.exception.custom.EmailAlreadyExistsException;
import com.example.first_spring.exception.custom.UsernameAlreadyExistsException;
import com.example.first_spring.model.RegularUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegularUserServiceImpl implements RegularUserService {

    /*
        TODO:
        - Create test case for changeUserEmail and getAllRegularUsers
        - Create controllers for the rest methods in service layer
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
    public void clearAll() {
        users.clear();
    }

    @Override
    public boolean createUser(RegularUserDto userDto) {
        for (RegularUser user : users) {
            if (user.getUsername().equalsIgnoreCase(userDto.username())) {
                throw new UsernameAlreadyExistsException("Username already exists!");
            }
            if (user.getEmail().equalsIgnoreCase(userDto.email())) {
                throw new EmailAlreadyExistsException("Email already exists!");
            }
        }
        RegularUser regularUser = new RegularUser.Builder()
                .username(userDto.username())
                .email(userDto.email())
                .build();

        return users.add(regularUser);
    }

    @Override
    public RegularUser getUserByUsername(String username) {
        return findRegularUserByUsernameInternally(username);
    }

    @Override
    public RegularUser getUserByEmail(String email) {
        return findRegularUserByEmailInternally(email);
    }

    @Override
    public List<RegularUser> getAllRegularUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public RegularUser changeUsernameByEmail(ChangeUsernameDto changeUsernameDto) {
        RegularUser user = findRegularUserByEmailInternally(changeUsernameDto.email());
        if (user == null) {
            return null;
        }
        user.setUsername(changeUsernameDto.newUsername());
        return user;
    }

    @Override
    public RegularUser changeUserEmailByUsername(ChangeUserEmailDto changeUserEmailDto) {
        RegularUser user = findRegularUserByUsernameInternally(changeUserEmailDto.username());
        if (user == null) {
            return null;
        }
        user.setEmail(changeUserEmailDto.newEmail());
        return user;
    }

    private RegularUser findRegularUserByEmailInternally(String email) {
        for (RegularUser user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    private RegularUser findRegularUserByUsernameInternally(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}