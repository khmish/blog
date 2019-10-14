package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.model.User;
import com.example.blog.service.BlogRespository;
import com.example.blog.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/main")
@RestController
public class BlogController {

    @Autowired
    BlogRespository blogRespository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String hello()
    {
        return "<h1>hello world</h1>";
    }
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> index()
    {

        return new ResponseEntity<List<Blog>>(blogRespository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addBlog")
    public Blog add(@RequestBody Map<String,String> body)
    {
        String title = body.get("title") ;
        String content = body.get("content");
        User nationalID = userRepository.findById(Integer.parseInt(body.get("nationalID"))).get();
//        userRepository

//        Blog blog= new Blog(title,content);
//        return new Blog(title,content,nationalID);
        return blogRespository.save(new Blog(title,content,nationalID));
//        return  blog;
    }
}
