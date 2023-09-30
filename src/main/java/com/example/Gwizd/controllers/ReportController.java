package com.example.Gwizd.controllers;

import com.example.Gwizd.models.Report;
import com.example.Gwizd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/report")
@RequiredArgsConstructor
public class ReportController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<String> addReport(@RequestBody Report report, Authentication authentication) {
        report.setIdUser(userService.getUserByEmail(authentication.getName()).getIdUser());
        return ResponseEntity.ok("");
    }
}
