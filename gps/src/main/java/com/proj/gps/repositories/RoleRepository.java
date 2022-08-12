package com.proj.gps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.gps.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
