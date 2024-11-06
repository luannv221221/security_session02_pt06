package com.ra.model.dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterResponseDTO {
    private String fullName;
    private String userName;
}
