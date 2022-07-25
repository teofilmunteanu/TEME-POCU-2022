package com.project.Tema7_springWeb.service;

import com.project.Tema7_springWeb.model.User;
import com.project.Tema7_springWeb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public User find(int id){
        return userRepository.retrieveById(id);
    }

    public void delete(int id){
        userRepository.delete(id);
    }

    public User update(int id, String name){
        User user = userRepository.retrieveById(id);

        user.setName(name);
        userRepository.update(user);

        return user;
    }

    @PostConstruct
    private void postConstruct(){
        User user1 = new User(1, "First User");
        create(user1);
    }
}
