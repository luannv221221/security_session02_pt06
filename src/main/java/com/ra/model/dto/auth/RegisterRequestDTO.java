package com.ra.model.dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterRequestDTO {
    private String fullName;
    private String userName;
    private String password;
}
