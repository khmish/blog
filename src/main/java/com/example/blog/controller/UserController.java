package com.example.blog.controller;


import com.example.blog.model.User;
import com.example.blog.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("muser")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user)
    {
        if(userRepository.save(new User(user.getName()))!=null)
            return true;
        else
            return false;
    }
}
