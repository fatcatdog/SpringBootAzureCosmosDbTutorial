package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

@Repository
public interface UserRepository extends DocumentDbRepository<User, String> { }
