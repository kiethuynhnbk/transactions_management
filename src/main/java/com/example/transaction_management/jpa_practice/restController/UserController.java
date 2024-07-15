package com.example.transaction_management.jpa_practice.restController;

import com.example.transaction_management.jpa_practice.dto.card.CardDTO;
import com.example.transaction_management.jpa_practice.entity.Card;
import com.example.transaction_management.jpa_practice.request.UserRequest;
import com.example.transaction_management.jpa_practice.service.CardService;
import com.example.transaction_management.jpa_practice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private CardService cardService;

    public UserController(UserService userService, CardService cardService)
    {
        this.userService = userService;
        this.cardService = cardService;
    }

    @PostMapping
    public boolean createUser(@RequestBody UserRequest request)
    {
        return userService.createUser(request);
    }

    @GetMapping("/{id}/cards")
    public List<CardDTO> getCardsOfUser(@PathVariable Long id)
    {
        return cardService.getCardsOfUser(id);
    }

    @DeleteMapping("/{userId}/cards/{cardId}")
    public CardDTO getCardsOfUser(@PathVariable Long userId, @PathVariable Long cardId)
    {
        return cardService.userRemoveCard(userId, cardId);
    }

    @PutMapping("/{userId}/cards/{cardId}")
    public CardDTO deactivateCardOUser(@PathVariable Long userId, @PathVariable Long cardId)
    {
        return cardService.userDeactiveCard(userId, cardId);
    }

}
