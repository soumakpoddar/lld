package org.example.AtmStates;

import org.example.pojo.Atm;
import org.example.pojo.Card;

public class IdleState extends AtmState {

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card inserted successfully");
        atm.setState(new HasCard());
    }
}
