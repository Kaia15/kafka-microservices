package com.utube.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utube.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
