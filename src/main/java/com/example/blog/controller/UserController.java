package com.example.blog.controller;


import com.example.blog.service.UserRepositoryCustom;
import com.example.blog.model.User;
import com.example.blog.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("muser")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user)
    {

        if(userRepository.save(new User(user.getName()))!=null && user.getName()!=null)
            return new ResponseEntity(true,HttpStatus.CREATED);
        else
            return new ResponseEntity(false,HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAll()
    {
        List<User> users= new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/allUsers")
    public List<User> getUsers()
    {
        return userRepository.getNames();
    }
}
