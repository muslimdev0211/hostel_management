package com.muslimdev.hostelmanegement.config;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetWithAuthenticationPrincipalAnnotationController {
    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal UserDetails userDetails){
        return "User Details:" + userDetails.getUsername();
    }

}
