package com.julia.road.controllers;

import com.julia.road.dto.UserDTO;
import com.julia.road.models.User;
import com.julia.road.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> findByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(userService.findByUserId(userId),HttpStatus.OK);
    }

    @DeleteMapping("/user/delete{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
}
