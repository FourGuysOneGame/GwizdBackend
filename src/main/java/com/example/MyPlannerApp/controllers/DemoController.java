package com.example.MyPlannerApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> getWeeks() {
        return ResponseEntity.ok("Hello!");
    }
}
