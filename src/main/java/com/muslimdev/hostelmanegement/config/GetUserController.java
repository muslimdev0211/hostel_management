package com.muslimdev.hostelmanegement.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetUserController {

    @GetMapping(value = "/username")
    public String currentUserName(Principal principal){
        return principal.getName();
    }
}
