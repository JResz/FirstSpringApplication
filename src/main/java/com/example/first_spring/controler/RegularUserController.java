package com.example.first_spring.controler;

import com.example.first_spring.dto.ChangeUserEmailDto;
import com.example.first_spring.dto.ChangeUsernameDto;
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

    @GetMapping
    public ResponseEntity<List<RegularUser>> getAllRegularUser() {
        return new ResponseEntity<>(regularUserService.getAllRegularUsers(), HttpStatus.OK);
    }

    @GetMapping("/find/by/username/{username}")
    public ResponseEntity<RegularUser> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(regularUserService.getUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/find/by/email/{email}")
    public ResponseEntity<RegularUser> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(regularUserService.getUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/changeUsername")
    public ResponseEntity<RegularUser> changeUsername(@RequestBody ChangeUsernameDto changeUsernameDto) {
        return new ResponseEntity<>(regularUserService.changeUsernameByEmail(changeUsernameDto), HttpStatus.CREATED);
    }

    @PutMapping("/changeEmail")
    public ResponseEntity<RegularUser> changeEmail(@RequestBody ChangeUserEmailDto changeUserEmailDto) {
        return new ResponseEntity<>(regularUserService.changeUserEmailByUsername(changeUserEmailDto), HttpStatus.CREATED);
    }

}

