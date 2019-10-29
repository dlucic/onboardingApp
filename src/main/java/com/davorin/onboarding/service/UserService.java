package com.davorin.onboarding.service;

import com.davorin.onboarding.model.User;
import com.davorin.onboarding.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void removeUser(Long id) {
        userRepository.removeUser(id);
    }
}
