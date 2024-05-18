package org.example.pojo;

import lombok.Data;

@Data
public class Payment {
    private Bill bill;

    public void payBill(Bill bill) {
        System.out.println("Bill paid successfully for amount : " + bill.getAmount());
    }
}
