package com.nutritiontracker.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


/**
 * Also defines validation.
 * If validation fails, server response is code 400.
 */
@Getter
@Setter
public class UserDTO {

    private long id;

    @Email
    @NotBlank
    private String email;


    @NotBlank
    @Size(min = 4)
    private String password;


    @JsonProperty("isAdmin")
    private boolean admin;


}
