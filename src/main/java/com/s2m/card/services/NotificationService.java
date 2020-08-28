package com.s2m.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.s2m.card.models.Notification;
import com.s2m.card.repositories.NotificationRepository;



@Component
public class NotificationService {
	 @Autowired
	 private NotificationRepository repository;
	 
	 public List<Notification> getAllNotificationsByUser(String username, String password) {
	        return repository.findByUsernameAndPassword(username, password);
	    }
	 
	 public List<Notification> getAllNotifications() {
	        return (List<Notification>) repository.findAll();
	    }

}
