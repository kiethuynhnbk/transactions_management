package com.example.transaction_management.jpa_practice.response;

import com.example.transaction_management.jpa_practice.enumiration.StatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {

    private final String username;

    private final String email;

    private final String avatarImg;

    private final StatusEnum status;


}
