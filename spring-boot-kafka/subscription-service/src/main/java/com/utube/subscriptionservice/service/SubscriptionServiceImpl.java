package com.utube.subscriptionservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utube.subscriptionservice.entity.Subscription;
import com.utube.subscriptionservice.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> listAll() {
        return subscriptionRepository.findAll();
    };
    public Subscription create(Subscription subscription) {
        return subscription;
    };
    public void saveOrUpdate(Subscription subscription) {
        subscriptionRepository.save(subscription);
    };
}
