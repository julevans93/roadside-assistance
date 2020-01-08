package com.julia.road.service;

import com.julia.road.dto.UserDTO;
import com.julia.road.models.User;
import com.julia.road.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser (UserDTO user){
        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());

        return userRepo.save(newUser);
    }

    public User updateUser (Long id, User newUserData){
        User user = userRepo.findById(id).get();

        user.setUsername(newUserData.getUsername());
        user.setPassword(newUserData.getPassword());
        user.setFirstName(newUserData.getFirstName());
        user.setLastName(newUserData.getLastName());
        user.setEmail(newUserData.getEmail());

        return userRepo.save(user);
    }

    public User findByUserId (Long id){
        return userRepo.findById(id).get();
    }

    public Boolean deleteUser (Long id) {
        User user = userRepo.findById(id).get();
        if (user != null){
            userRepo.delete(user);
            return true;
        }
        return false;
    }
}
