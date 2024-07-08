package com.example.transaction_management.redis_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfor {

    private Long id;

    private String username;

    private String imgUrl;
}
