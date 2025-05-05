package com.example.first_spring.controler;
import com.example.first_spring.dto.UserDto;
import com.example.first_spring.model.HelloUser;
import com.example.first_spring.service.HelloUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloUserService helloUserService;

    public HelloController() {
        this.helloUserService = new HelloUserService();
    }

    @GetMapping("/world")
    public ResponseEntity<String> helloWorld () {
            return new ResponseEntity<>("Hello World", HttpStatus.CREATED); //protokół https
    }

    @GetMapping("/dupa")
    public ResponseEntity<String> hellodupa () {
        return new ResponseEntity<>("Hello Dupa", HttpStatus.OK); //protokół https
    }

    @GetMapping
    public ResponseEntity<String> hellojakub () {
        return new ResponseEntity<>("Hello Jakub", HttpStatus.ACCEPTED); //protokół https
    }

    @PostMapping("/addUser")
    public ResponseEntity<HelloUser> hellouser (@RequestBody UserDto userDto) {
        return new ResponseEntity<>(helloUserService.createUser(userDto), HttpStatus.CREATED); //
    }

    //pobrac aplikacje co sie nazywa postman i wysłać post request

}
