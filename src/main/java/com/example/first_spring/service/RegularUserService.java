package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;

import java.util.List;

public interface RegularUserService {

    void clearAll();

    boolean createUser(RegularUserDto userDto);

    RegularUser getUserByUsername(String username);

    RegularUser getUserByEmail(String email);

    List<RegularUser> getAllRegularUsers();

    RegularUser changeUsernameByEmail(ChangeUsernameDto changeUsernameDto);

    RegularUser changeUserEmailByUsername(ChangeUserEmailDto changeUserEmailDto);
}