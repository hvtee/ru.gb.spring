package com.example.services;

import com.example.models.Role;
import com.example.models.User;
import com.example.repositories.RoleRepository;
import com.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserDetailsService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
