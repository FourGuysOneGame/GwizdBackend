package com.example.MyPlannerApp.services;

import com.example.MyPlannerApp.models.UsersWeeks;
import com.example.MyPlannerApp.repositories.UserWeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWeekService {
    private final UserWeekRepository userWeekRepository;

    public UserWeekService(UserWeekRepository userWeekRepository) {
        this.userWeekRepository = userWeekRepository;
    }

    public List<UsersWeeks> getUserWeeks() {
        return userWeekRepository.findAll();
    }
}
