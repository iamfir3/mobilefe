package com.mobilebe.dto;

import com.mobilebe.util.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private Role role;
    private String firstName;
    private String lastName;
}
