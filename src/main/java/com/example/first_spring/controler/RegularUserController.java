package com.example.first_spring.controler;

import com.example.first_spring.dto.RegularUserDto;
import com.example.first_spring.model.RegularUser;
import com.example.first_spring.service.RegularUserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regularUser")
public class RegularUserController {

    private final RegularUserServiceImpl regularUserService;

    public RegularUserController() {
        this.regularUserService = new RegularUserServiceImpl();
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addRegularUser(@RequestBody RegularUserDto userDto) {
        boolean created = regularUserService.createUser(userDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RegularUser>> getAllRegularUser() {
        List<RegularUser> users = regularUserService.getAllRegularUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{user}")
    public ResponseEntity<RegularUser> getUserByUsername(@RequestParam("username") String username) {
        RegularUser user = regularUserService.getUserByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{user}")
    public ResponseEntity<RegularUser> getUserByEmail(@RequestParam("email") String email) {
        RegularUser user = regularUserService.getUserByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put")
    public ResponseEntity<RegularUser> changeUsername(@RequestParam String regularUserDto, @RequestParam String newUsernameDto) {
        RegularUser user = regularUserService.getUserByUsername(regularUserDto);
        if (user != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setUsername(newUsernameDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<RegularUser> changeUserEmail(@RequestParam String regularUserDto, @RequestParam String newEmailDto) {
        RegularUser user = regularUserService.getUserByEmail(regularUserDto);
        if (user != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setEmail(newEmailDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

