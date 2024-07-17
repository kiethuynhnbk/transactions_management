package com.example.transaction_management.jpa_practice.entity;

import com.example.transaction_management.jpa_practice.enumiration.CardTypeEnum;
import com.example.transaction_management.jpa_practice.enumiration.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq_gen")
    @SequenceGenerator(name = "card_seq_gen", sequenceName = "default_seq", allocationSize = 1)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardTypeEnum cardType;

    @Column
    private Long balance;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusEnum status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
