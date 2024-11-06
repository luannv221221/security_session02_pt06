package com.ra.model.dto.auth;

import com.ra.model.entity.Role;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponseDTO {
    private String fullName;
    private String username;
    private String accessToken;
    private String typeToken;
    private Set<Role> roles;
}
