package org.alejandria.bookapp.controller;

import org.alejandria.bookapp.model.UserEntity;
import org.alejandria.bookapp.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bda")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserEntity> getUsers(){
        return this.userService.getAll();
    }

    @GetMapping("users/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @GetMapping("users/email/{email}")
    public UserEntity getUserByEmail(@PathVariable String email){
        return this.userService.getByEmail(email);
    }

    @PostMapping
    public ResponseEntity<UserEntity> newUser(@Validated @RequestBody UserEntity user) {

        if(this.userService.getByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
    }

}
