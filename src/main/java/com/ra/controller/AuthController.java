package com.ra.controller;

import com.ra.model.dto.auth.LoginRequestDTO;
import com.ra.model.dto.auth.LoginResponseDTO;
import com.ra.model.dto.auth.RegisterRequestDTO;
import com.ra.model.dto.auth.RegisterResponseDTO;
import com.ra.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = authService.login(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO){
        return new ResponseEntity<>(authService.register(requestDTO),HttpStatus.CREATED);
    }
}
