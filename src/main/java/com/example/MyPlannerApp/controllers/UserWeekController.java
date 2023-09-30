package com.example.MyPlannerApp.controllers;

import com.example.MyPlannerApp.models.UsersWeeks;
import com.example.MyPlannerApp.services.UserWeekService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user-weeks")
public class UserWeekController {
    private final UserWeekService userWeekService;

    public UserWeekController(UserWeekService userWeekService) {
        this.userWeekService = userWeekService;
    }


    @GetMapping
    public List<UsersWeeks> getUserWeeks() {
        return userWeekService.getUserWeeks();
    }
}
