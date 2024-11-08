package com.ra.model.dto.auth;

import com.ra.model.entity.Role;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserResponseDTO {
    private String username;
    private String fullName;
    private Set<Role> roles;
}
