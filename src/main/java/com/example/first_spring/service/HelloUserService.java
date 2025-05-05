package com.example.first_spring.service;
import com.example.first_spring.dto.UserDto;
import com.example.first_spring.model.HelloUser;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloUserService {
    private final List<HelloUser> users;

    public HelloUserService() {
        users = new ArrayList<>();
    }

    public HelloUser createUser(UserDto userDto) {
        HelloUser newUser = new HelloUser();
        newUser.setUsername(userDto.username());
        newUser.setEmail(userDto.username());
        newUser.setID(userDto.ID());
        users.add(newUser);
        return newUser;
    }

    public HelloUser getUserById(Integer Id) {
        return users.stream().filter(x -> x.getID().equals(Id)).findFirst().get();
    }
}







