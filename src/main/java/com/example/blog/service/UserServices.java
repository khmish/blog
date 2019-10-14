package com.example.blog.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServices {
    @PersistenceContext
    EntityManager em;


    public List getAllUser() {
        return em.createNamedStoredProcedureQuery("getAllUser").getResultList();
    }
}
