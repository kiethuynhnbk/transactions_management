package com.example.transaction_management.jpa_practice.restController;

import com.example.transaction_management.jpa_practice.request.TransactionRequest;
import com.example.transaction_management.jpa_practice.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionRequest performTransaction(@Valid @RequestBody TransactionRequest transactionRequest)
    {
        return transactionService.performTransaction(transactionRequest);
    }
}
