package com.project.Tema7_springWeb.controller;

import com.project.Tema7_springWeb.exceptions.InvalidIdException;
import com.project.Tema7_springWeb.exceptions.UserNotFoundException;
import com.project.Tema7_springWeb.model.User;
import com.project.Tema7_springWeb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value="/api/users/create")
    public User create(@Valid @RequestBody User user){
        return userService.create(user);
    }

    @GetMapping(value="/api/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value="/api/users/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        if(id<0){
            throw new InvalidIdException();
        }

        User user = userService.find(id);
        if(Objects.isNull(user)){
            throw new UserNotFoundException();
        }

        return user;
    }

    @DeleteMapping(value="/api/users/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.delete(id);
    }

    @PostMapping(value="api/users/update/{id}")
    public User updateUser(@PathVariable int id, @Valid @RequestBody User user){
        return userService.update(id, user.getName());
    }
}
