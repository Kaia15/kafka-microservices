package com.utube.userservice.kafka.producer;

// import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.utube.userservice.kafka.event.UserCreatedEvent;
import com.utube.userservice.kafka.event.UserSubscribedEvent;
// import com.utube.userservice.kafka.config.KafkaTopicConfig;
import com.utube.userservice.kafka.event.UserUpdatedEvent;

@Service
public class UserProducer {
    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
    // private NewTopic topic;
    private KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;
    private KafkaTemplate<String, UserSubscribedEvent> kafkaTemplate1;
    private KafkaTemplate<String, UserUpdatedEvent> kafkaTemplate2;
    // private KafkaTopicConfig topicConfig;

    public UserProducer(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate, 
                        KafkaTemplate<String, UserSubscribedEvent> kafkaTemplate1, KafkaTemplate<String, UserUpdatedEvent> kafkaTemplate2) {
        // this.topic = newTopic;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate1 = kafkaTemplate1;
        this.kafkaTemplate2 = kafkaTemplate2;
        // this.topicConfig = kafkaTopicConfig;
    }

    public void sendMessage(UserCreatedEvent event, String topicName) {
        // NewTopic topic = topicConfig.topic(topicName);
        logger.info(String.format("User event => %s", event.toString()));
        Message<UserCreatedEvent> message = MessageBuilder.withPayload(event)
                                                            .setHeader(KafkaHeaders.TOPIC, topicName)
                                                            .build();
        kafkaTemplate.send(message);
    }

    public void sendSubscriptionPayload(UserSubscribedEvent event, String topicName) {
        // NewTopic topic = topicConfig.topic(topicName);
        logger.info(String.format("User subscribing event => %s", event.toString()));
        Message<UserSubscribedEvent> message = MessageBuilder.withPayload(event)
                                                            .setHeader(KafkaHeaders.TOPIC, topicName)
                                                            .build();
        kafkaTemplate1.send(message);
    }

    public void sendModifiedUserPayload(UserUpdatedEvent event, String topicName) {
        logger.info(String.format("User updated event => %s", event.toString()));
        Message<UserUpdatedEvent> message = MessageBuilder.withPayload(event)
                                                            .setHeader(KafkaHeaders.TOPIC, topicName)
                                                            .build();
        kafkaTemplate2.send(message);
    }
}
