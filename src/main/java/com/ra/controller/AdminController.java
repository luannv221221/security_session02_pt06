package com.ra.controller;

import com.ra.model.dto.auth.UserRequestDTO;
import com.ra.model.dto.auth.UserResponseDTO;
import com.ra.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AuthService authService;
    @GetMapping
    public ResponseEntity<?> admin(){
        return new ResponseEntity<>("Xin chào ADMIN", HttpStatus.OK);
    }
    @PostMapping("/auth/create")
    public ResponseEntity<UserResponseDTO> createAccount(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO responseDTO = authService.createAccount(userRequestDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @GetMapping("/auth")
    public ResponseEntity<List<UserResponseDTO>> getAllAccount(){
        return new ResponseEntity<>(authService.findAll(),HttpStatus.OK);
    }
}
