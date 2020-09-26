package com.seavus.notes.service;

import com.seavus.notes.model.User;
import com.seavus.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username) {
        User user = new User(username);
        userRepository.save(user);

    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
