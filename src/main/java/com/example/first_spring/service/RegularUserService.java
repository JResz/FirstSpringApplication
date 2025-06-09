package com.example.first_spring.service;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;

import java.util.List;

public interface RegularUserService {

    boolean createUser(RegularUserDto userDto);

    RegularUser getUserByUsername(String username);

    List<RegularUser> getAllRegularUsers();

    RegularUser getUserByEmail(String email);

    RegularUser changeUsername(ChangeUsernameDto changeUsernameDto);

    RegularUser changeUserEmail(ChangeUserEmailDto changeUserEmailDto);
}