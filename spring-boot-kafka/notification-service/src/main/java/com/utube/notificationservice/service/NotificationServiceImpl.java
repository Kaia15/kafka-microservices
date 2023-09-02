package com.utube.notificationservice.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.utube.notificationservice.entity.Notification;
import com.utube.notificationservice.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    public List<Notification> listAll() {
        return notificationRepository.findAll();
    };
    public Notification create(Notification notification) {
        return notification;
    };
    public void saveOrUpdate(Notification notification) {
        notificationRepository.save(notification);
    };
}
