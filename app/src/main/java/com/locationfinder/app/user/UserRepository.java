package com.locationfinder.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // Find a user by username
    Optional<UserEntity> findByUsername(String username);

    // Find a user by email
    Optional<UserEntity> findByEmail(String email);
}