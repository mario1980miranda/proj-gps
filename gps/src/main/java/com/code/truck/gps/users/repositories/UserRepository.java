package com.code.truck.gps.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.truck.gps.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
