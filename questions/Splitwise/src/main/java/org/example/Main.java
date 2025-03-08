package org.example;

// Requirements:
// 1. Add expense
// 2. Edit expenses
// 3. Settle expenses
// 4. Add, edit or settle group expenses
// 5. Simplify expenses
// 6. Comments
// 7. Activity log

import org.example.entity.Balance;
import org.example.entity.Expense;
import org.example.entity.User;
import org.example.service.CurrencyConvertorService;
import org.example.service.ExpenseManagerService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CurrencyConvertorService currencyConvertorService = new CurrencyConvertorService();
        ExpenseManagerService expenseService = new ExpenseManagerService(currencyConvertorService);

        User aman = new User("1", "Aman");
        User uddeshya = new User("2", "Uddeshya");
        User soumak = new User("3", "Soumak");
        Expense expense = new Expense(
                "1",
                "Trio1"
        );

        // cricket...
        expenseService.addExpense(
                expense,
                soumak,
                Map.of(
                        aman, new Balance(150, "INR"),
                        uddeshya, new Balance(150, "INR")
                ),
                "INR"
        );
        expenseService.displayExpense(expense, "INR");

        // food...
        expenseService.addExpense(
                expense,
                aman,
                Map.of(
                        soumak, new Balance(500, "INR"),
                        uddeshya, new Balance(500, "INR")
                ),
                "INR"
        );
        expenseService.displayExpense(expense, "INR");

        // settle expenses...
        expenseService.settleExpense(expense, "INR");
        expenseService.displayExpense(expense, "INR");
    }
}