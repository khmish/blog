package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.model.User;
import com.example.blog.service.BlogRespository;
import com.example.blog.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> index()
    {
        List<Blog> blogs= new ArrayList<Blog>();
        blogRespository.findAll().forEach(blogs::add);
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @PostMapping("/addBlog")
    public Blog add(@RequestBody Blog body)
    {
        String title= body.getTitle();
        String content= body.getContent();
        User nationalID= body.getUser();
        userRepository.findById(body.getUser().getNationalID()).get();

//        Blog blog= new Blog(title,content);
//        return new Blog(title,content,nationalID);
        return blogRespository.save(new Blog(title,content,nationalID));
//        return  blog;
    }
}
