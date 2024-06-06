package com.nutritiontracker.model.service;

import com.nutritiontracker.data.entity.UserEntity;
import com.nutritiontracker.data.repository.UserRepository;
import com.nutritiontracker.model.dto.UserDTO;
import com.nutritiontracker.model.exception.DuplicateEmailException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO create(UserDTO userDTO) {

        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            userEntity = userRepository.save(userEntity);

            UserDTO result = new UserDTO();
            result.setId(userEntity.getId());
            result.setEmail(userEntity.getEmail());

            return result;

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found."));
    }

}
