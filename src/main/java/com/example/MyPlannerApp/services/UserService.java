package com.example.MyPlannerApp.services;

import com.example.MyPlannerApp.controllers.authentication.AuthenticationRequest;
import com.example.MyPlannerApp.controllers.authentication.AuthenticationResponse;
import com.example.MyPlannerApp.controllers.authentication.RegisterRequest;
import com.example.MyPlannerApp.models.User;
import com.example.MyPlannerApp.models.UserDetailsEntity;
import com.example.MyPlannerApp.repositories.UserDetailsEntityRepository;
import com.example.MyPlannerApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailsEntityRepository userDetailsEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("user with email: " + email + " does not exist")
        );
    }

    public AuthenticationResponse register(RegisterRequest request) {

        UUID idUserDetailsEntity = UUID.randomUUID();
        User user = User.builder()
                .idUser(UUID.randomUUID())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .idUserDetails(idUserDetailsEntity)
                .build();
        UserDetailsEntity userDetailsEntity = UserDetailsEntity.builder()
                .idUserDetails(idUserDetailsEntity)
                .name(request.getName())
                .surname(request.getSurname())
                .build();


        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent())
            throw new IllegalStateException("user with email: " + request.getEmail() + " already exists");

        userDetailsEntityRepository.save(userDetailsEntity);
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalStateException(
                        "user with email: " + request.getEmail() + " does not exist"
                ));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id: " + userId + " does not exist"
                ));
        userDetailsEntityRepository.deleteById(user.getIdUserDetails());
        userRepository.deleteById(userId);
    }

}
