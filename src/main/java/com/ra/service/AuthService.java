package com.ra.service;

import com.ra.model.dto.auth.LoginRequestDTO;
import com.ra.model.dto.auth.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO requestDTO);
}
