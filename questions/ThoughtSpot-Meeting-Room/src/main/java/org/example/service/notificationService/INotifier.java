package org.example.service.notificationService;

import org.example.entity.User;

public interface INotifier {
    void notify(String message, User user);
}
