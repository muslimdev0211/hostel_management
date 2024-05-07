package com.muslimdev.hostelmanegement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.muslimdev.hostelmanegement.dto.UserDto;
import com.muslimdev.hostelmanegement.dto.UserResponse;
import com.muslimdev.hostelmanegement.entity.Users;
import com.muslimdev.hostelmanegement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return ResponseEntity.ok(userDto);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updateUserFields(@PathVariable Long id,@RequestBody Map<String, Object> fields){
        return ResponseEntity.ok(userService.updateProductByFields(id,fields));
    }
    @GetMapping("/users/{userId}")
    public UserResponse findUser(@PathVariable Long userId){
        return userService.findId(userId);
    }
    @GetMapping("/users")
    public ResponseEntity findAll(){
        List <UserResponse> usersList = userService.findAllUsers();
        return ResponseEntity.ok(usersList);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity deleted(@PathVariable Long userId){
        userService.deleteId(userId);
        return ResponseEntity.ok("User is deleted");
    }



}
