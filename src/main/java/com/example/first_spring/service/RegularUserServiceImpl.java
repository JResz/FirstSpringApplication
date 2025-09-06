package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.exception.custom.EmailAlreadyExistsException;
import com.example.first_spring.exception.custom.EmailNotExistsException;
import com.example.first_spring.exception.custom.UsernameAlreadyExistsException;
import com.example.first_spring.exception.custom.UsernameDoesNotExistException;
import com.example.first_spring.model.RegularUser;
import com.example.first_spring.repo.RegularUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RegularUserServiceImpl implements RegularUserService {

    /*
        TODO:
        In MySQL, create a new user with the username test_user and password password,
        and grant them all privileges on the regularuserdb database. This is necessary
        to ensure the same configuration on our both laptops.

        Create a method that deletes a user from the database by email, and
        create an appropriate controller for it using @DeleteMapping.

        For the next meeting:
        Transactions should be applied to some methods in the service layer.
    */

    private final RegularUserRepository regularUserRepository;

    @Override
    public void createUser(RegularUserDto userDto) {
        for (RegularUser user : regularUserRepository.findAll()) {
            if (user.getUsername().equalsIgnoreCase(userDto.username())) {
                throw new UsernameAlreadyExistsException("Username already exists!");
            }
            if (user.getEmail().equalsIgnoreCase(userDto.email())) {
                throw new EmailAlreadyExistsException("Email already exists!");
            }
        }
        RegularUser regularUser = RegularUser.builder()
                .username(userDto.username())
                .email(userDto.email())
                .build();

        regularUserRepository.save(regularUser);
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
        return new ArrayList<>(regularUserRepository.findAll());
    }

    @Override
    public RegularUser changeUsernameByEmail(ChangeUsernameDto changeUsernameDto) {
        RegularUser user = findRegularUserByEmailInternally(changeUsernameDto.email());
        boolean result = regularUserRepository.findAll().stream()
                .anyMatch(username -> username.getUsername().equalsIgnoreCase(changeUsernameDto.newUsername()));
        if (result) {
            throw new UsernameAlreadyExistsException("This username already exists");
        }
        user.setUsername(changeUsernameDto.newUsername());
        return user;
    }

    @Override
    public RegularUser changeUserEmailByUsername(ChangeUserEmailDto changeUserEmailDto) {
        RegularUser user = findRegularUserByUsernameInternally(changeUserEmailDto.username());
        boolean result = regularUserRepository.findAll().stream()
                .anyMatch(x -> x.getEmail().equalsIgnoreCase(changeUserEmailDto.newEmail()));
        if (result) {
            throw new EmailAlreadyExistsException("This email already exists");
        }
        user.setEmail(changeUserEmailDto.newEmail());
        return user;
    }

    private RegularUser findRegularUserByEmailInternally(String email) {
        for (RegularUser user : regularUserRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new EmailNotExistsException("This email does not exist in the database.");
    }

    private RegularUser findRegularUserByUsernameInternally(String username) {
        return regularUserRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(
                        () -> new UsernameDoesNotExistException("This username does not exist in the database")
                );
    }
}