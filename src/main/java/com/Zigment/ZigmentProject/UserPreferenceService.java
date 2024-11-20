package com.Zigment.ZigmentProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPreferenceService {

    @Autowired
    private UserPreferenceRepository repository;

    public UserPreference create(UserPreference userPreference) {
        return repository.save(userPreference);
    }

    public Optional<UserPreference> findById(String userId) {
        return repository.findById(userId);
    }

    public UserPreference update(String userId, UserPreference userPreference) {
        userPreference.setUserId(userId);
        return repository.save(userPreference);
    }

    public void delete(String userId) {
        repository.deleteById(userId);
    }
}

