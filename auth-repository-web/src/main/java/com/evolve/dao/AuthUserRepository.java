package com.evolve.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evolve.model.User;

@Repository
public interface AuthUserRepository extends CrudRepository<User, Long> {
    ArrayList<User> findAllUser();
}
