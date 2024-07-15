package com.example.transaction_management.jpa_practice.dto.card;

import com.example.transaction_management.jpa_practice.entity.Card;
import com.example.transaction_management.jpa_practice.enumiration.CardTypeEnum;
import com.example.transaction_management.jpa_practice.enumiration.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CardDTO {

    private Long id;

    private String cardNumber;

    private CardTypeEnum cardType;

    private Long balance;

    private StatusEnum status;

    public CardDTO convert(Card card)
    {
        return CardDTO.builder().id(card.getId())
                .cardNumber(card.getCardNumber())
                .cardType(card.getCardType())
                .balance(card.getBalance())
                .status(card.getStatus())
                .build();
    }
}
