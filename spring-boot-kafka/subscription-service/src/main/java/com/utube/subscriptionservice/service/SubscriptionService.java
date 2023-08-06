package com.utube.subscriptionservice.service;

import java.util.List;

import com.utube.subscriptionservice.entity.Subscription;

public interface SubscriptionService {
    public List<Subscription> listAll();
    public Subscription create(Subscription subscription);
    public void saveOrUpdate(Subscription subscription);
}
