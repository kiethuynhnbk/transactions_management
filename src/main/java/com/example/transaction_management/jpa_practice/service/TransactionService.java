package com.example.transaction_management.jpa_practice.service;

import com.example.transaction_management.jpa_practice.entity.Card;
import com.example.transaction_management.jpa_practice.request.TransactionRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private CardService cardService;

    public TransactionService(CardService cardService)
    {
        this.cardService = cardService;
    }

    @Transactional
    public TransactionRequest performTransaction(TransactionRequest transactionRequest)
    {
        Card from = cardService.findCardByCardNumberForUpdate(transactionRequest.getFromCardNumber());

        Card to = cardService.findCardByCardNumberForUpdate(transactionRequest.getToCardNumber());

        from.setBalance(from.getBalance() - transactionRequest.getAmount());

        to.setBalance(to.getBalance() + transactionRequest.getAmount());

        cardService.saveCard(from);

        cardService.saveCard(to);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return transactionRequest;
    }
}
