package com.example.hello.repository;

import com.example.hello.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer> {

}
