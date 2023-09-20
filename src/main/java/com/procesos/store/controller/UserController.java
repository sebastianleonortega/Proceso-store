package com.procesos.store.controller;

import com.procesos.store.model.User;
import com.procesos.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
     return ResponseEntity.ok(userService.getUserById(id));
    };

    @PostMapping("users")
    public ResponseEntity<User>  Create(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);

    }

    @PutMapping("users/{id}")
    public ResponseEntity<User>  update(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String>  delete(@PathVariable Long id){
        return new ResponseEntity(userService.delete(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
