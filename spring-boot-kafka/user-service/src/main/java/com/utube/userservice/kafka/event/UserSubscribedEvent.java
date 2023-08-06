package com.utube.userservice.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserSubscribedEvent {
    private String message;
    private String status;
    private Long subscriberId;
    private Long subscribeeId;
    private String subscriberName;
    private String subscribeeName;
    
    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubscriberId(Long id) {
        this.subscriberId = id;
    }

    public void setSubscribeeId(Long id) {
        this.subscribeeId = id;
    }

    public void setSubscribeeName(String name) {
        this.subscribeeName = name;
    }

    public void setSubscriberName(String name) {
        this.subscriberName = name;
    }
}
