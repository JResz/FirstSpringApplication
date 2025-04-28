package com.example.first_spring.controler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

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
}
