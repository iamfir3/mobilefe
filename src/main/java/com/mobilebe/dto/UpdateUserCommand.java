package com.mobilebe.dto;

import com.mobilebe.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserCommand {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private String phone;

}
