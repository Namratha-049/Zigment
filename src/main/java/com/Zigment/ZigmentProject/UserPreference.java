package com.Zigment.ZigmentProject;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Null;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Date;
import java.util.Map;

@Data
@Document(collection = "user_preferences")
public class UserPreference {

    @Id
    private String userId;

    @Email
    @NotNull
    private String email;

    @Null
    private Map<String, Object> preferences;

    @Pattern(regexp = "^[a-zA-Z/_]+$", message = "Invalid timezone format")
    @NotNull
    private String timezone;

    private Date lastUpdated;
    private Date createdAt;
}
