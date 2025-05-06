package com.example.first_spring.controler;

import com.example.first_spring.model.VipUserBuilder;
import com.example.first_spring.service.HelloVipUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vipUser")
public class HelloVipUserController {

    private final HelloVipUserService helloVipUserService;

    public HelloVipUserController() {
        this.helloVipUserService = new HelloVipUserService();
    }

    @GetMapping("/test")
    public ResponseEntity<VipUserBuilder> getTestVipUser() {
        return new ResponseEntity<>(helloVipUserService.getTestUserBuilder(), HttpStatus.OK);
    }
}
