package com.API_Load._esting.service;

import com.API_Load._esting.entity.User;
import com.API_Load._esting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.LinkOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setAge(userDetails.getAge());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setGender(userDetails.getGender());
            return userRepository.save(user);
        });
    }


    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

}
