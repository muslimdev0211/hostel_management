package com.muslimdev.hostelmanegement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.muslimdev.hostelmanegement.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserResponse {
    private Role userRoleId;
    private String userName;
    private String userEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userDob;
    private String userAdress;
}
