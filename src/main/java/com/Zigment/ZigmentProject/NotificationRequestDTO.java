package com.Zigment.ZigmentProject;


import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Data
public class NotificationRequestDTO {

    @NotNull
    private String userId;

    @NotNull
    private String type; 

    @NotNull
    private String channel; 

    private Map<String, Object> content;
}

