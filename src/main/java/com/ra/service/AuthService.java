package com.ra.service;

import com.ra.model.dto.auth.LoginRequestDTO;
import com.ra.model.dto.auth.LoginResponseDTO;
import com.ra.model.dto.auth.RegisterRequestDTO;
import com.ra.model.dto.auth.RegisterResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO requestDTO);
    RegisterResponseDTO register(RegisterRequestDTO requestDTO);
}
