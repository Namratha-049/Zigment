package com.Zigment.ZigmentProject;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@Document(collection = "notification_logs")
public class NotificationLog {

    @Id
    private String id;

    private String userId;
    private String type; 
    private String channel; 
    private String status; 
    private Date sentAt;
    private String failureReason;
    private Map<String, Object> metadata;
}

