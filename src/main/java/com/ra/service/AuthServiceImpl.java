package com.ra.service;

import com.ra.model.dto.auth.LoginRequestDTO;
import com.ra.model.dto.auth.LoginResponseDTO;
import com.ra.model.dto.auth.RegisterRequestDTO;
import com.ra.model.dto.auth.RegisterResponseDTO;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.RoleRepository;
import com.ra.repository.UserRepository;
import com.ra.security.UserPrinciple;
import com.ra.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        Authentication authentication;
        authentication = authenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(),requestDTO.getPassword()));
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return LoginResponseDTO.builder()
                .username(userPrinciple.getUsername())
                .fullName(userPrinciple.getUser().getFullName())
                .accessToken(jwtProvider.generateToken(userPrinciple))
                .typeToken("Bearer")
                .roles(userPrinciple.getUser().getRoles())
                .build();
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO requestDTO) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findRoleByRoleName("USER");
        roles.add(role);
        User userEntity = User.builder()
                .userName(requestDTO.getUserName())
                .fullName(requestDTO.getFullName())
                .passowrd(new BCryptPasswordEncoder().encode(requestDTO.getPassword()))
                .status(true)
                .roles(roles)
                .build();
        User user = userRepository.save(userEntity);
        return RegisterResponseDTO.builder()
                .fullName(user.getFullName())
                .userName(user.getUserName())
                .build();
    }
}
