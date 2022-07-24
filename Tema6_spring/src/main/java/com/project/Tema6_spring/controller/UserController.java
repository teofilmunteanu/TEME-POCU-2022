package com.project.Tema6_spring.controller;

import com.project.Tema6_spring.model.User;
import com.project.Tema6_spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value="/api/users/create")
    public User create(@Valid @RequestBody User user){
        return userService.create(user);
    }

    @GetMapping(value="/api/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value="/api/users/{id}")
    public User getUser(@PathVariable int id){
        return userService.find(id);
    }

    @DeleteMapping(value="/api/users/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.delete(id);
    }

}
