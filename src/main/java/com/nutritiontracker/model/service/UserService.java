package com.nutritiontracker.model.service;

import com.nutritiontracker.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    /**
     * creates new user according to the parameter data and returns the newly created user as DTO
     * including the actual id
     * @param userDTO
     * @return
     */
    UserDTO create(UserDTO userDTO);

}
