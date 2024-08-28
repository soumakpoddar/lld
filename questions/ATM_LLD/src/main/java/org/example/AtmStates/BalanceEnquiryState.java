package org.example.AtmStates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.pojo.Atm;
import org.example.pojo.Card;

@EqualsAndHashCode(callSuper = true)
@Data
public class BalanceEnquiryState extends AtmState {
    @Override
    public void balanceEnquiry(Atm atm, Card card) {
        System.out.println("Your balance is: " + card.getBalance());
        exit(atm);
    }
}
