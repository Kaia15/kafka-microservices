package com.utube.emailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utube.emailservice.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{
    
}
