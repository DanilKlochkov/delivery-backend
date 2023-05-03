package com.blablaeda.deliverybackend.controller;

import com.blablaeda.deliverybackend.dto.AuthResponse;
import com.blablaeda.deliverybackend.dto.LoginDto;
import com.blablaeda.deliverybackend.postgres.entity.user.User;
import com.blablaeda.deliverybackend.security.CurrentUser;
import com.blablaeda.deliverybackend.security.TokenProvider;
import com.blablaeda.deliverybackend.service.user.UserService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private Random random;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final UserService userService;
    private final CurrentUser currentUser;

    @GetMapping("/sendCode")
    public ResponseEntity<String> sendSms(
            @RequestParam("phone") String phone
    ) {
//        var message = "Ваш код для входа - " + (1000 + random.nextInt(8999));
//        Twilio.init("sid", "auth");
//        Message.creator(new PhoneNumber(phone), new PhoneNumber("num"), message);
        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginDto dto
    ) {
        var user = userService.login(dto);
        var g = authenticateAndGetToken(user.getPhoneNumber(), dto.code());
        return ResponseEntity.ok(new AuthResponse(g));
    }

    @GetMapping("/me")
    public ResponseEntity<User> me() {
        return ResponseEntity.ok(currentUser.getUser());
    }

    private String authenticateAndGetToken(String username, String password) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return tokenProvider.generate(authentication);
    }
}
