package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;


public class CardValidation {

    public static void validateCard(Card card) {
        if (card == null) {
            throw new CardException("Request invalid: Card cannot be null");
        }

        if (card.getType() == null && card.getValue() == null) {
            throw new CardException("Request invalid: Card must have a type or value");
        }

        if (card.getType() != null && card.getValue() != null) {
            throw new CardException("Request invalid: Card cannot have both type and value");
        }

        if (card.getType() == Type.JOKER && (card.getValue() != null || card.getColor() != null)) {
            throw new CardException("Request invalid: JOKER card must not have value or color");
        }
    }

    public static void validateColor(String color) {
        boolean validColor = false;
        for (Color cardColor : Color.values()) {
            if (cardColor.name().equalsIgnoreCase(color)) {
                validColor = true;
                break;
            }
        }

        if (!validColor) {
            throw new CardException("Invalid color");
        }
    }
}