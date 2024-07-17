package com.example.transaction_management.jpa_practice.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionRequest {

    @NotBlank(message = "fromAccount is mandatory")
    private final String fromCardNumber;

    @NotBlank(message = "toAccount is mandatory")
    private final String toCardNumber;

    @NotNull(message = "amount is mandatory")
    @Min(value = 5000 , message = "Value should be greater then then equal to 5000")
    private final Long amount;


}
