package org.example.AtmStates;

import org.example.pojo.Atm;
import org.example.pojo.Card;

public class HasCard extends AtmState {
    public HasCard() {
        System.out.println("Enter your card pin number : ");
    }

    @Override
    public void authenticatePin(Atm atm, Card card, int pin) {
        boolean correctPin = card.checkPin(pin);
        if (correctPin) {
            System.out.println("Pin authenticated successfully");
            atm.setState(new SelectOperationState());
        } else {
            System.out.println("Invalid pin");
            returnCard();
            exit(atm);
        }
    }

    private void returnCard() {
        System.out.println("Card returned");
    }
}
