package com.EasyBid.UserService.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNumber;
    private String address;

}
