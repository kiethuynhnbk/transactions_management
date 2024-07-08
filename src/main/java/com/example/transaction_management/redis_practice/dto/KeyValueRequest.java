package com.example.transaction_management.redis_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class KeyValueRequest {

    private String key;

    private String value;

    private Long TTL;
}
