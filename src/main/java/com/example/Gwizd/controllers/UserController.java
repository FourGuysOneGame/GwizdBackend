package com.example.Gwizd.controllers;

import com.example.Gwizd.controllers.requests_and_responses.AuthenticationRequest;
import com.example.Gwizd.controllers.requests_and_responses.AuthenticationResponse;
import com.example.Gwizd.controllers.requests_and_responses.RegisterRequest;
import com.example.Gwizd.models.User;
import com.example.Gwizd.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> getUser(@RequestBody User user) {

        User databaseUser = userService.getUserByEmail(user.getEmail());
        if (Objects.equals(databaseUser.getPassword(), user.getPassword()))
            return new ResponseEntity<>(user.getIdUser().toString(), HttpStatus.OK);
        else
            return new ResponseEntity<>(user.getIdUser().toString(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/auth/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(userService.authenticate(request));
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity<String> deleteUser(Authentication authentication) {
        UUID userId = userService.getUserByEmail(authentication.getName()).getIdUser();
        userService.deleteUser(userId);
        return ResponseEntity.ok(String.valueOf(userId));
    }
}
