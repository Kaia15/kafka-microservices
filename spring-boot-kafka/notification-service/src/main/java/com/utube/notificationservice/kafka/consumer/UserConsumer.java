package com.utube.notificationservice.kafka.consumer;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.utube.notificationservice.entity.Notification;
import com.utube.notificationservice.repository.NotificationRepository;
import com.utube.notificationservice.service.NotificationServiceImpl;
import com.utube.userservice.kafka.event.UserSubscribedEvent;

@Service
public class UserConsumer {
    private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);
    private NotificationServiceImpl notificationSrvc;
    private NotificationRepository notificationRepository;

    @Autowired
    public UserConsumer(NotificationServiceImpl notificationSrvc, NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
        this.notificationSrvc = notificationSrvc;
    }

    @KafkaListener(topics = "${spring.kafka.user-subscribe-topic.name}", groupId = "${spring.kafka.consumer.group-id}", concurrency = "2")
    public void consume(UserSubscribedEvent event) {
        logger.info(String.format("User subscribed event => %s", event));
        Notification subscribee_noti_payload = new Notification();
        Notification subscriber_noti_payload = new Notification();
        String subscribee = event.getSubscribeeName();
        String subscriber = event.getSubscriberName();
        LocalDateTime time = LocalDateTime.now();
        String subscribee_message = subscriber + "subscribed your channels" + time.toString();
        String subscriber_message = "You will receive notifications from " +  subscribee;

        subscribee_noti_payload.setNotificationMessage(subscribee_message);
        subscribee_noti_payload.setNotificationRecipient(event.getSubscribeeId());
        notificationSrvc.saveOrUpdate(subscribee_noti_payload);

        subscriber_noti_payload.setNotificationMessage(subscriber_message);
        subscriber_noti_payload.setNotificationRecipient(event.getSubscriberId());
        notificationSrvc.saveOrUpdate(subscriber_noti_payload);
    }
}
