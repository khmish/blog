package com.example.blog.controller;


import com.example.blog.model.User;
import com.example.blog.service.UserRepository;
import com.example.blog.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("muser")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

    @PostMapping("/addUser")
    public ResponseEntity <Boolean> addUser(@RequestBody User user)
    {
        return new ResponseEntity((userRepository.save(new User(user.getName())) != null), HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public List allUsers (){
        return userServices.getAllUser();
    }
}
