package com.example.transaction_management.jpa_practice.service;

import com.example.transaction_management.jpa_practice.dto.card.CardDTO;
import com.example.transaction_management.jpa_practice.entity.Card;
import com.example.transaction_management.jpa_practice.entity.User;
import com.example.transaction_management.jpa_practice.enumiration.StatusEnum;
import com.example.transaction_management.jpa_practice.repository.CardRepository;
import com.example.transaction_management.jpa_practice.repository.UserRepository;
import com.example.transaction_management.jpa_practice.request.CardRequest;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private CardRepository cardRepository;

    private UserRepository userRepository;

    public CardService(UserRepository userRepository, CardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

//    @Cacheable(value = "users", key = "#id")
//    public User getRandom(Long id)
//    {
//        return User.builder().id(id).username("123").build();
//    }

    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id)
    {
        System.out.println("CALLED IF CACHE NOT HIT");
        User user = userRepository.findById(id).orElseThrow(() ->
        {throw new RuntimeException("Not found user");});
        return user;
    }

    public CardRequest createCard(CardRequest request)
    {

        User user = getUserById(request.getUserId());

        if(!user.getStatus().equals(StatusEnum.ACTIVE) &&
                !user.getStatus().equals(StatusEnum.NONCONFIMRED))
        {
            throw new RuntimeException("USER IS BLOCKED...");
        }

        Card card = Card.builder()
                .cardNumber(request.getCardNumber())
                .cardType(request.getCardType())
                .balance(request.getBalance())
                .status(StatusEnum.ACTIVE)
                .user(user).build();

        cardRepository.save(card);

        return request;
    }

    @Cacheable(value = "users-cards", key = "#id")
    public List<CardDTO> getCardsOfUser(Long id)
    {
        System.out.println("SHOW IF CACHE MISS");
        User user = getUserById(id);
        List<CardDTO> result = user.getCards().stream()
                .map(card -> new CardDTO().convert(card))
                .collect(Collectors.toList());
        return result;
    }

    @CacheEvict(value = "users-cards", key = "#userId")
    public CardDTO userRemoveCard(Long userId, Long id)
    {
        User user = getUserById(userId);
        Card deletedCard = cardRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Card not found");
        });

        if(!deletedCard.getUser().getId().equals(userId))
        {
            throw new RuntimeException("Not valid user");
        }

        cardRepository.delete(deletedCard);
        return new CardDTO().convert(deletedCard);
    }

    @CacheEvict(value = "users-cards", key = "#userId")
    public CardDTO userDeactiveCard(Long userId, Long id)
    {
        User user = getUserById(userId);
        Card deactivateCard = cardRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Card not found");
        });

        if(!deactivateCard.getUser().getId().equals(userId))
        {
            throw new RuntimeException("Not valid user");
        }

        deactivateCard.setStatus(StatusEnum.DEACTIVATE);

        cardRepository.save(deactivateCard);
        return new CardDTO().convert(deactivateCard);
    }

    @Transactional
    public Card findCardByCardNumberForUpdate(String cardNumber)
    {
        return cardRepository.findByCardNumberForUpdateWithWriteLock(cardNumber)
                .orElseThrow(() -> {throw new RuntimeException("Card Number not found");});

    }

    public boolean saveCard(Card card)
    {
        this.cardRepository.saveAndFlush(card);
        return true;
    }



}
