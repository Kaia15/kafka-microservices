package com.utube.notificationservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utube.notificationservice.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
    
}
