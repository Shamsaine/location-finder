package com.locationfinder.app.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Create or update a user
    public UserEntity saveUser(UserEntity user) {
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Retrieve all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public Optional<UserEntity> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    // Retrieve a user by username
    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Retrieve a user by email
    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Delete a user by ID
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}