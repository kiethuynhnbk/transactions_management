package com.example.transaction_management.jpa_practice.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRequest {

    private final String username;

    private final String password;

    private final String email;

}
