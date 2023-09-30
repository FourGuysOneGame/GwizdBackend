package com.example.MyPlannerApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value = "/")
    public String index() {
        return "login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping(value = "/addTask")
    public String addTask() {
        return "addTask";
    }

    @GetMapping(value = "/daily")
    public String daily() {
        return "daily";
    }

    @GetMapping(value = "/weekly")
    public String weekly() {
        return "weekly";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "redirect:/";
    }
}
