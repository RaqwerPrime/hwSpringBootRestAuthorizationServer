package ru.netology.hwspringbootrestauthorizationserver.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hwspringbootrestauthorizationserver.customAnotation.UserParams;
import ru.netology.hwspringbootrestauthorizationserver.domain.User;
import ru.netology.hwspringbootrestauthorizationserver.exception.InvalidCredentials;
import ru.netology.hwspringbootrestauthorizationserver.exception.UnauthorizedUser;
import ru.netology.hwspringbootrestauthorizationserver.service.Authorities;
import ru.netology.hwspringbootrestauthorizationserver.service.AuthorizationService;


import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public ResponseEntity<?> getAuthorities(@Valid @UserParams User user) {
        List<Authorities> authorities = service.getAuthorities(user);
        return ResponseEntity.ok(authorities);
    }
}

