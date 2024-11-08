package com.ra.service;

import com.ra.model.dto.auth.*;

import java.util.List;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO requestDTO);
    RegisterResponseDTO register(RegisterRequestDTO requestDTO);
    UserResponseDTO createAccount(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> findAll();
}
