package com.ra.model.dto.auth;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {
    private String fullName;
    private String password;
    private String username;
    private Set<String> roles;
}
