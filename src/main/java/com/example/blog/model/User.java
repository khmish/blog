package com.example.blog.model;

import javax.persistence.*;
import java.util.List;

@Table(name ="User")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nationalID;

    private String name;


    @OneToMany( cascade = CascadeType.ALL)
    private List<Blog> blogs;

    public User() {
    }

    public User( String name) {

        this.name = name;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "nationalID='" + nationalID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
