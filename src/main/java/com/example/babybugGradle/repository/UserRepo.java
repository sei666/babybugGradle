package com.example.babybugGradle.repository;

import com.example.babybugGradle.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository <UserEntity, Long>{
    UserEntity findByUsername(String username);
}
