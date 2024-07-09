package org.example.pojo;

import lombok.Data;

@Data
public class Payment {
    private int paymentId;
    private String paymentType;
    private double amount;
    private String status;
    private String transactionId;
    private String paymentDate;
}
