package com.utube.subscriptionservice.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.utube.subscriptionservice.entity.Subscription;
import com.utube.subscriptionservice.repository.SubscriptionRepository;
import com.utube.subscriptionservice.service.SubscriptionServiceImpl;
import com.utube.userservice.kafka.event.UserSubscribedEvent;

@Service
public class UserConsumer {
    private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);
    private SubscriptionServiceImpl subscriptionSrvc;
    private SubscriptionRepository subscriptionRepository;
    
    @Autowired
    public UserConsumer(SubscriptionServiceImpl subscriptionService, SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionSrvc = subscriptionService;
    }

    @KafkaListener(topics = "${spring.kafka.user-subscribe-topic.name}", groupId = "spring.kafka.consumer.group-id")
    public void consume(UserSubscribedEvent event) {
        logger.info(String.format("User subscribed event => %s", event));
        Subscription subscription_payload = new Subscription();
        subscription_payload.setSubcribeeId(event.getSubscribeeId());
        subscription_payload.setSubscriberId(event.getSubscriberId());
        subscription_payload.setSubscribeeName(event.getSubscribeeName());
        subscription_payload.setSubscriberName(event.getSubscriberName());
        subscription_payload.setSubscriptionMessage("Thank you for your subscribing");
        subscriptionSrvc.saveOrUpdate(subscription_payload);

    }
}
