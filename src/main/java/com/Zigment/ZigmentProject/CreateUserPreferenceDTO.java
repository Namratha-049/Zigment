package com.Zigment.ZigmentProject;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Map;

@Data
public class CreateUserPreferenceDTO {

    @NotNull
    private String userId;

    @Email
    @NotNull
    private String email;

    @NotNull
    private Map<String, Object> preferences;

    @Pattern(regexp = "^[a-zA-Z/_]+$", message = "Invalid timezone format")
    @NotNull
    private String timezone;
}
