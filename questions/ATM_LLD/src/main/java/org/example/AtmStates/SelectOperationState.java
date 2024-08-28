package org.example.AtmStates;

import org.example.pojo.Atm;
import org.example.pojo.Card;
import org.example.pojo.TransactionType;

public class SelectOperationState extends AtmState {
    public SelectOperationState() {
        System.out.println("Select operation: ");
        System.out.println("1. Cash withdrawal");
        System.out.println("2. Balance enquiry");
    }

    @Override
    public void selectOperation(Atm atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case CASH_WITHDRAWAL -> atm.setState(new CashWithdrawalState());
            case BALANCE_ENQUIRY -> atm.setState(new BalanceEnquiryState());
            default -> {
                System.out.println("Invalid operation");
                exit(atm);
            }
        }
    }
}
