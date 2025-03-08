package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class Expense {
    private String expenseId;
    private String name;
    private Map<User, Balance> expenses;
    private boolean isSettled;

    public Expense(String expenseId, String name) {
        this.expenseId = expenseId;
        this.name = name;
        this.expenses = new HashMap<>();
        this.isSettled = false;
    }

    public Map<User, Balance> getExpenses() {
        return expenses;
    }

    public void setSettled(boolean isSettled) {
        this.isSettled = isSettled;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public String getExpenseName() {
        return name;
    }
}
