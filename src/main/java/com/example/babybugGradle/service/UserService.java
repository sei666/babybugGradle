package com.example.babybugGradle.service;

import com.example.babybugGradle.entity.UserEntity;
import com.example.babybugGradle.exception.UserAlreadyExistException;
import com.example.babybugGradle.exception.UserMissingException;
import com.example.babybugGradle.model.User;
import com.example.babybugGradle.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("User Already Exist");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserMissingException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserMissingException("User Missing");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
