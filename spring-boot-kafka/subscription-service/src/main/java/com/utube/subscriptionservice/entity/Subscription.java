package com.utube.subscriptionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;
    private Long subscriberId;
    private Long subscribeeId;
    private String subscriptionMessage;
    private String subscriberName;
    private String subscribeeName;

    public void setSubscriberId(Long id) {
        this.subscriberId = id;
    }

    public void setSubcribeeId(Long id) {
        this.subscribeeId = id;
    }

    public void setSubscriptionMessage(String message) {
        this.subscriptionMessage = message;
    }
}
