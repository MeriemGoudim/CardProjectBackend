package com.s2m.card.controllers;


import com.s2m.card.models.Notification;
import com.s2m.card.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/all/{username}/{password}")
    public List<Notification> getAllNotificationsByUser(@PathVariable(required = true) String username, @PathVariable(required = true)String password){
        return notificationService.getAllNotificationsByUser(username, password);
    }
    
    @GetMapping("/all")
    public List<Notification> getAllNotifications(){
    	return notificationService.getAllNotifications();
    }

}
