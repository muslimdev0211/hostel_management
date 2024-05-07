package com.muslimdev.hostelmanegement.controller;

import com.muslimdev.hostelmanegement.dto.RoleDto;
import com.muslimdev.hostelmanegement.entity.Role;
import com.muslimdev.hostelmanegement.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("role")
    public ResponseEntity saveRole(@RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
        return  ResponseEntity.ok(roleDto);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("deleted");
    }
    @GetMapping("/role/{id}")
    public ResponseEntity getRole(@PathVariable Long id){
        Role role = roleService.getById(id);
        return ResponseEntity.ok(role);
    }
    @PutMapping("/role/{id}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleDto, @PathVariable Long id){
         roleService.addRole(roleDto);
         return ResponseEntity.ok(roleDto);
    }
}
