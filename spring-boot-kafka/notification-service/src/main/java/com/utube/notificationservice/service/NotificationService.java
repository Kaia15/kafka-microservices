package com.utube.notificationservice.service;

import java.util.List;

import com.utube.notificationservice.entity.Notification;

public interface NotificationService {
    public List<Notification> listAll();
    public Notification create(Notification notification);
    public void saveOrUpdate(Notification notification);
}
