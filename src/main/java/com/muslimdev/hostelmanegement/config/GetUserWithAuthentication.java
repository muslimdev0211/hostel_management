package com.muslimdev.hostelmanegement.config;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserWithAuthentication {

    @GetMapping(value = "/username1")
    public String currentUserName(Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        return authentication.getName();
    }
}
