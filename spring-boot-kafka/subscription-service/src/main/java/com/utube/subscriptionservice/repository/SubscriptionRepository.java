package com.utube.subscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utube.subscriptionservice.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    
}
