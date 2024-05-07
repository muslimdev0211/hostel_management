package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.UserDto;
import com.muslimdev.hostelmanegement.dto.UserResponse;
import com.muslimdev.hostelmanegement.entity.Users;
import com.muslimdev.hostelmanegement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;




    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    public UserResponse updateProductByFields(Long id, Map<String, Object> fields) {
        Optional<Users> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Users.class, key);
                field.setAccessible(true);
                if(field.getType().equals(Date.class)) {

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
                    formatter.setTimeZone(TimeZone.getTimeZone("Uzbekistan/Tashkent"));

                    try {
                        Date value1 = formatter.parse(String.valueOf(value));

                        ReflectionUtils.setField(field, existingUser.get(), value1);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }else
                    ReflectionUtils.setField(field, existingUser.get(), value);

            });

            userRepository.save(existingUser.get());
            return toDto(existingUser.get());
        }
        return null;
    }

    public Users addUser(UserDto userdto) {
        Users users = toEntity(userdto);

        return userRepository.save(users);
    }

    public UserResponse findId(Long userId) {
        Optional<Users> users = userRepository.findById(userId);
        if (users.isEmpty()) {
            return null;
        }
        return toDto(users.get());
    }

    public Users getEntityById(Long id){
        Optional <Users> usersOptional = userRepository.findById(id);
        if (usersOptional.isEmpty())
            return null;
        else
            return usersOptional.get();
    }

    public List<UserResponse> findAllUsers() {
        List<UserResponse> usersList = new ArrayList<>();
        for (Users users: userRepository.findAll()){
            usersList.add(toDto(users));
        }
        return usersList;
    }

    public void deleteId(Long id) {
        userRepository.deleteById(id);
    }

//public Users update(UserDto userDto){
//        Users users = toDto(userDto);
//        return userRepository
//}

    public Users toEntity(UserDto userDto) {
        Users users = new Users();
        users.setUserName(userDto.getUserName());
        users.setUserEmail(userDto.getUserEmail());
        users.setUserAdress(userDto.getUserAdress());
        users.setUserDob(userDto.getUserDob());
        if (userDto.getUserRoleId()!=null){
        users.setUserRoleId(roleService.findRoleId(userDto.getUserRoleId()));
        }

        return users;
    }
    public UserResponse toDto(Users users){
        UserResponse userResponse = new UserResponse();
        userResponse.setUserRoleId(users.getUserRoleId());
        userResponse.setUserName(users.getUserName());
        userResponse.setUserAdress(users.getUserAdress());
        userResponse.setUserDob(users.getUserDob());
        userResponse.setUserEmail(users.getUserEmail());
        return userResponse;
    }

}
