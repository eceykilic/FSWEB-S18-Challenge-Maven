package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")

public class CardController {
    private CardRepositoryImpl cardRepository;

    @Autowired
    public CardController(CardRepositoryImpl cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping()
    public List<Card> findAll(){
        return cardRepository.findAll();
    }


    @GetMapping("/byColor/{color}")
    public List<Card> findByColor(@PathVariable String color){
        List<Card> cards = cardRepository.findByColor(color);
        if (cards.isEmpty()) {
            throw new CardException("No cards found with color: " + color, HttpStatus.NOT_FOUND);
        }
        return cards;
    }


    @PostMapping()
    public Card save(@RequestBody Card card){
        cardRepository.save(card);
        return card;
    }

    @PutMapping("/{id}")
    public Card update(@PathVariable Integer id,@RequestBody Card card){
        Card existingCard=cardRepository.findById(id);
        cardRepository.update(card);
        return card;
    }

    @DeleteMapping("/{id}")
    public Card remove(@PathVariable Long id){
        return cardRepository.remove(id);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> findByValue(@PathVariable Integer value){
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> findByType(@PathVariable String type){
        return cardRepository.findByType(type);
    }
}