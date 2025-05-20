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
        return new ResponseEntity<>(regularUserService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegularUser>> getAllRegularUser() {
        return new ResponseEntity<>(regularUserService.getAllRegularUsers(), HttpStatus.OK);
    }

    // How to use RequestParam in url and show alternative
    // Use the better naming strategy
    @GetMapping("/get")
    public ResponseEntity<RegularUser> getUserByEmail(@RequestParam("email") String email) {
        RegularUser user= regularUserService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    Wrong mapping and status code
//    @GetMapping("/put")
//    public ResponseEntity<RegularUser> changeUsername(String username) {
//        RegularUser user = regularUserService.getUserByUsername(username);
//        user.setUsername(username);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}


