package com.Zigment.ZigmentProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationLogRepository repository;

    public NotificationLog sendNotification(NotificationLog log) {
        log.setStatus("sent");
        log.setSentAt(new java.util.Date());
        return repository.save(log);
    }

    public List<NotificationLog> getLogs(String userId) {
        return repository.findByUserId(userId);
    }
}

