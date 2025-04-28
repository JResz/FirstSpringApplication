package com.example.first_spring.service;
import com.example.first_spring.model.HelloUser;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    @Service
    public class HelloUserService {
        private final List<HelloUser> users = new ArrayList<>();

        public HelloUserService(String username, String email, Integer ID) {
            List<HelloUserService> usersCreated = new ArrayList<>();
        }

        public HelloUser createUserById(String username, String email, Integer ID) {
            for (HelloUser user : users) {
                if (user.getID().equals(ID)) {
                    return user;
                }
            }

            HelloUser newUser = new HelloUser(username, email, ID);
            saveUser(newUser);
            return newUser;
        }

        private void saveUser(HelloUser user) {
            users.add(user);
        }

        public HelloUser getUserById(Integer Id) {
                for (HelloUser user : users) {
                if (user.getID().equals(Id)) {
                    return user;
                }
            }
            return null;
        }

//        public HelloUser removeUserById(Integer Id) {
//            Iterator<HelloUser> iterator = users.iterator();
//            while (iterator.hasNext()) {
//
            }







