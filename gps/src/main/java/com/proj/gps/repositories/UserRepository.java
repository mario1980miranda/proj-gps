package com.proj.gps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.gps.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
