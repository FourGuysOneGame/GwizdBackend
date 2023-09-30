package com.example.Gwizd.controllers;

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
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello!");
    }
}
