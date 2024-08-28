package org.example.AtmStates;

import lombok.Data;
import org.example.pojo.Atm;
import org.example.pojo.Card;
import org.example.pojo.TransactionType;

@Data
public abstract class AtmState {

    public void insertCard(Atm atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(Atm atm, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(Atm atm, Card card, TransactionType txnType) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void balanceEnquiry(Atm atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(Atm atm) {
        atm.setState(new IdleState());
    }
}
