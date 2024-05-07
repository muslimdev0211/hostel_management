package com.muslimdev.hostelmanegement.dto;

import com.muslimdev.hostelmanegement.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserDto {
    private Long userRoleId;
    private String userName;
    private String userEmail;
    private Date userDob;
    private String userAdress;

}
