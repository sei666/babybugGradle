package com.example.babybugGradle.controller;

import com.example.babybugGradle.entity.UserEntity;
import com.example.babybugGradle.exception.UserAlreadyExistException;
import com.example.babybugGradle.exception.UserMissingException;
import com.example.babybugGradle.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User created");
        } catch(UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR SERVER");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch(UserMissingException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR SERVER");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR SERVER");
        }
    }

//    @GetMapping
//    public ResponseEntity getUsers(){
//        try {
//            return ResponseEntity.ok("OK SERVER");
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body("ERROR SERVER");
//        }
//    }
}
