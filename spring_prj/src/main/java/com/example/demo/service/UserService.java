package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
@Service
@Transactional(rollbackFor=Exception.class)
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User>searchAll(){
        return userRepository.findAll();
    }

    public void create(UserRequest userRequest){
        User user=new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }
}