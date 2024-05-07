package com.muslimdev.hostelmanegement.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetWithHTTPServletRequestController {

    @GetMapping(value = "/username2")
    public String currentUserNameSimple(HttpServletRequest httpServletRequest) {
        Principal principal = httpServletRequest.getUserPrincipal();
        return principal.getName();
    }
}
