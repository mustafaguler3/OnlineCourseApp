package com.example.repository.concretes;

import com.example.entities.concretes.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

}























