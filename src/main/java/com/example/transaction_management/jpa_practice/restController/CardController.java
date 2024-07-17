package com.example.transaction_management.jpa_practice.restController;

import com.example.transaction_management.jpa_practice.entity.Card;
import com.example.transaction_management.jpa_practice.entity.User;
import com.example.transaction_management.jpa_practice.request.CardRequest;
import com.example.transaction_management.jpa_practice.service.CardService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService)
    {
        this.cardService = cardService;
    }

    @PostMapping
    public CardRequest createCard(@RequestBody CardRequest cardRequest)
    {
        return cardService.createCard(cardRequest);
        //return cardService.getUserById(103L);
    }

    @GetMapping("/{cardNumber}")
    public Card getCardByCardNumber(@PathVariable String cardNumber)
    {
        return cardService.findCardByCardNumberForUpdate(cardNumber);
    }
}
