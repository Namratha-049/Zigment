package com.Zigment.ZigmentProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/preferences")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService service;

    @PostMapping
    public ResponseEntity<UserPreference> create(@Valid @RequestBody CreateUserPreferenceDTO dto) {
        UserPreference userPreference = new UserPreference();
        userPreference.setUserId(dto.getUserId());
        userPreference.setEmail(dto.getEmail());
        userPreference.setPreferences(dto.getPreferences());
        userPreference.setTimezone(dto.getTimezone());
        userPreference.setCreatedAt(new java.util.Date());
        return ResponseEntity.ok(service.create(userPreference));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserPreference> get(@PathVariable String userId) {
        return service.findById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserPreference> update(
            @PathVariable String userId,
            @Valid @RequestBody CreateUserPreferenceDTO dto) {
        UserPreference userPreference = new UserPreference();
        userPreference.setEmail(dto.getEmail());
        userPreference.setPreferences(dto.getPreferences());
        userPreference.setTimezone(dto.getTimezone());
        return ResponseEntity.ok(service.update(userId, userPreference));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable String userId) {
        service.delete(userId);
        return ResponseEntity.noContent().build();
    }
}
