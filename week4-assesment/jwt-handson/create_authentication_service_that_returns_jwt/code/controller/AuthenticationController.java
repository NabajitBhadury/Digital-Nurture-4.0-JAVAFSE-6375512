package com.cognizant.jwt_demo.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static java.security.MessageDigest.getInstance;

@RestController
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationManager authenticationManager;
    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String,String>> authenticate(@RequestBody Map<String, String> credentials) {
        try {
            String username = credentials.get("username");
            String password = credentials.get("password");

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            Map<String, String> response = new HashMap<>();
            String token = generateToken(username);
            response.put("token", token);
            logger.info("Authentication successful for user {}", username);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Authentication failed", e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid username or password");
            return ResponseEntity.status(401).body(errorResponse);
        }


    }

    private String generateToken(
            String username
    ) throws NoSuchAlgorithmException, NoSuchAlgorithmException {
        String password = "secrect";
        MessageDigest digest = getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        SecretKey key = Keys.hmacShaKeyFor(hash);
        return Jwts.builder()
                .subject(username)
                .issuer("cognizant")
                .claim("roles", "USER")
                .expiration(new java.util.Date(System.currentTimeMillis() + 3600000)) // 1-hour expiration
                .signWith(key)
                .compact();
    }


}
