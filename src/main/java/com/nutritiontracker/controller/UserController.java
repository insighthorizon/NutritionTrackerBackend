package com.nutritiontracker.controller;

import com.nutritiontracker.data.entity.UserEntity;
import com.nutritiontracker.model.dto.UserDTO;
import com.nutritiontracker.model.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping({"/user", "/user/"})
    public UserDTO addUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PostMapping({"/auth", "/auth/"})
    public UserDTO login(@RequestBody @Valid UserDTO userDTO,
                         HttpServletRequest req) throws ServletException {
        req.login(userDTO.getEmail(), userDTO.getPassword());

        UserEntity currentUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDTO model = new UserDTO();
        model.setEmail(currentUser.getEmail());
        model.setId(currentUser.getId());
        model.setAdmin(currentUser.isAdmin());

        return model;

    }

    @DeleteMapping({"/auth", "/auth/"})
    public String logout(HttpServletRequest req) throws ServletException {
        req.logout();
        return "User logged out.";
    }

    @GetMapping({"/auth", "/auth/"})
    public UserDTO getCurrentUser() throws  ServletException {
        try {
            UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            UserDTO model = new UserDTO();
            model.setEmail(userEntity.getEmail());
            model.setId(userEntity.getId());
            model.setAdmin(userEntity.isAdmin());

            return model;
        } catch (ClassCastException e) { // no user logged in
            throw new ServletException();
        }
    }


    @ExceptionHandler(ServletException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // send code 401 to the client
    public void handleServletException() {}


}
