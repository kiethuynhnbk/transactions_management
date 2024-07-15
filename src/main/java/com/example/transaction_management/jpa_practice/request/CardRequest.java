package com.example.transaction_management.jpa_practice.request;

import com.example.transaction_management.jpa_practice.enumiration.CardTypeEnum;
import lombok.Data;

@Data
public class CardRequest{

    private final Long userId;

    private final String cardNumber;

    private final CardTypeEnum cardType;

    private final Long balance;


}
