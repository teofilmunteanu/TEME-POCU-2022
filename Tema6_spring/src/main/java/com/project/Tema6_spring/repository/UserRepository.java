package com.project.Tema6_spring.repository;

import com.project.Tema6_spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        users.add(user);
        return user;
    }

    public User retrieveById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void delete(int id){
        users.removeIf(user->user.getId() == id);
    }
}
