package com.muslimdev.hostelmanegement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class InMemoryAuthWebSecurityConfigurer {

    @Override
    public InMemoryUserDetailsManager userDetailsManager(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails userDetails = User.withUsername("Spring")
                .password(passwordEncoder.encode("realmadrid"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
