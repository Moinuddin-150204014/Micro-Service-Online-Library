package com.moin.UserService.controller;

import com.moin.UserService.entity.UserEntity;
import com.moin.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.createUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){

        try {
            UserEntity user = userService.getUserByUserId(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>>  getAllUser(){
       List<UserEntity> allUser = userService.getAllUser();
       return ResponseEntity.ok(allUser);
    }
}
