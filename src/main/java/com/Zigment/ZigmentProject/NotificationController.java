package com.Zigment.ZigmentProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/send")
    public ResponseEntity<NotificationLog> send(@Valid @RequestBody NotificationRequestDTO dto) {
        NotificationLog log = new NotificationLog();
        log.setUserId(dto.getUserId());
        log.setType(dto.getType());
        log.setChannel(dto.getChannel());
        log.setMetadata(dto.getContent());
        return ResponseEntity.ok(service.sendNotification(log));
    }

    @GetMapping("/{userId}/logs")
    public ResponseEntity<List<NotificationLog>> getLogs(@PathVariable String userId) {
        return ResponseEntity.ok(service.getLogs(userId));
    }
}

