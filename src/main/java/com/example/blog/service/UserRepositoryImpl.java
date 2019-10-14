package com.example.blog.service;

import com.example.blog.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getNames() {
        StoredProcedureQuery findByYearProcedure =
                em.createNamedStoredProcedureQuery("getNames");

        return findByYearProcedure.getResultList();
    }
}
