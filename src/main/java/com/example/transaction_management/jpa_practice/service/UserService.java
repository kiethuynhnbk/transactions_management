package com.example.transaction_management.jpa_practice.service;

import com.example.transaction_management.jpa_practice.entity.User;
import com.example.transaction_management.jpa_practice.enumiration.StatusEnum;
import com.example.transaction_management.jpa_practice.repository.UserRepository;
import com.example.transaction_management.jpa_practice.request.UserRequest;
import com.example.transaction_management.jpa_practice.response.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    public boolean createUser(UserRequest request)
    {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .status(StatusEnum.ACTIVE)
                .build();

        user = userRepository.save(user);
        return true;
    }

    public UserInfo getUserInfoById(Long id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("User not found");});

        return null;
                

    }
}
