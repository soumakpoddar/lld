package org.example.service.notificationService.impl;

import org.example.entity.User;
import org.example.service.notificationService.INotifier;

public class NotifyWithEmail implements INotifier {

    @Override
    public void notify(String message, User user) {
        System.out.println("Email sent to " + user.getEmailId() + " with message: " + message);
    }
}
