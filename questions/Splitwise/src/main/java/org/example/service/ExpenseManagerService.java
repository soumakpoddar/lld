package org.example.service;

import org.example.entity.Balance;
import org.example.entity.Expense;
import org.example.entity.User;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class ExpenseManagerService {
    private final CurrencyConvertorService currencyConvertorService;

    public ExpenseManagerService(CurrencyConvertorService currencyConvertorService) {
        this.currencyConvertorService = currencyConvertorService;
    }

    public void displayExpense(Expense expense, String currency) {
        System.out.println("Expense Name: " + expense.getExpenseName());
        System.out.println("--------------------Expense Details--------------------");
        System.out.println("Expense Settled: " + expense.isSettled());
        for (Map.Entry<User, Balance> e : expense.getExpenses().entrySet()) {
            double amount = currencyConvertorService.convertCurrency(e.getValue().getAmount(), e.getValue().getCurrency(), currency);
            if (amount < 0) {
                System.out.println(
                        e.getKey().getUserName() +
                        " needs to pay " +
                        Math.abs(amount) + " " + currency);
                continue;
            } else {
                System.out.println(
                        e.getKey().getUserName() +
                        " will get back " +
                        amount + " " + currency);
            }
        }
        System.out.println("------------------------------------------------------");
    }

    public void addExpense(Expense expense, User from, Map<User, Balance> to, String currency) {
        if (expense.isSettled()) {
            System.out.println("Cannot add expense to settled expense");
            return;
        }
        double fromTotal = expense.getExpenses().getOrDefault(from, new Balance(0, currency)).getAmount();
        fromTotal = currencyConvertorService.convertCurrency(
            fromTotal,
            expense.getExpenses().getOrDefault(from, new Balance(0, currency)).getCurrency(),
            currency
        );
        for (Map.Entry<User, Balance> e : to.entrySet()) {
            double toGive = e.getValue().getAmount();
            toGive = currencyConvertorService.convertCurrency(toGive, e.getValue().getCurrency(), currency);
            fromTotal += toGive;
            double currentUserTotal = expense.getExpenses().getOrDefault(e.getKey(), new Balance(0, currency)).getAmount();
            currentUserTotal = currencyConvertorService.convertCurrency(
                    currentUserTotal,
                    expense.getExpenses().getOrDefault(e.getKey(), new Balance(0, currency)).getCurrency(), currency)
            ;
            expense.getExpenses().put(e.getKey(), new Balance(currentUserTotal - toGive, currency));
        }
        expense.getExpenses().put(from, new Balance(fromTotal, currency));
    }

    public void settleExpense(Expense expense, String settlingCurrency) {
        PriorityQueue<Pair> negativeBalances = new PriorityQueue<>(Comparator.comparing(pair -> pair.balance));
        PriorityQueue<Pair> positiveBalances = new PriorityQueue<>(Comparator.comparing((Pair pair) -> pair.balance).reversed());
        for (Map.Entry<User, Balance> e : expense.getExpenses().entrySet()) {
            double amount = currencyConvertorService.convertCurrency(e.getValue().getAmount(), e.getValue().getCurrency(), settlingCurrency);
            if (amount < 0) {
                negativeBalances.add(new Pair(e.getKey(), amount));
            } else if (amount > 0) {
                positiveBalances.add(new Pair(e.getKey(), amount));
            }
        }
        while (!negativeBalances.isEmpty() && !positiveBalances.isEmpty()) {
            Pair negative = negativeBalances.poll();
            Pair positive = positiveBalances.poll();
            double settlingAmount = Math.min(-1 * negative.balance, positive.balance);
            if (-1 * negative.balance >= positive.balance) {
                System.out.println(negative.user.getUserName() + " pays " + positive.user.getUserName() + " " + settlingAmount + " " + settlingCurrency);
                negative.balance += settlingAmount;
                if (negative.balance < 0) {
                    negativeBalances.add(negative);
                }
            } else {
                System.out.println(negative.user.getUserName() + " pays " + positive.user.getUserName() + " " + settlingAmount + " " + settlingCurrency);
                positive.balance -= settlingAmount;
                if (positive.balance > 0) {
                    positiveBalances.add(positive);
                }
            }
        }
        expense.setSettled(true);
    }

    class Pair {
        User user;
        double balance;

        Pair(User user, double balance) {
            this.user = user;
            this.balance = balance;
        }
    }
}
