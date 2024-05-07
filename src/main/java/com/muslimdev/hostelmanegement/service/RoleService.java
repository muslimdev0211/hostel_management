package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.RoleDto;
import com.muslimdev.hostelmanegement.entity.Role;
import com.muslimdev.hostelmanegement.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addRole(RoleDto roleDto){
        Role role = new Role();
        role.setRoleTitle(roleDto.getRoleTitle());
        role.setRoleDescription(roleDto.getRoleDescription());
        return  roleRepository.save(role);
    }
        public Role findRoleId(Long id){
            Optional<Role> role = roleRepository.findById(id);
        return role.get();
    }
    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
    public Role getById(Long id){
        Role role = roleRepository.getById(id);
        return role;
    }
}
