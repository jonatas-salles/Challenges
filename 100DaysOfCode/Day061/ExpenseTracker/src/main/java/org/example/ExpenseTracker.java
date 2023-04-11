package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExpenseTracker {
    private final User user;
    private final List<Expense> expenses = new ArrayList<Expense>();

    public ExpenseTracker(User user) {
        this.user = user;
    }

    public void addExpense(Expense expense) {
        if (expense.getPrice()<=0) return;
        expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        if (!expenses.contains(expense)) return;
        expenses.remove(expense);
    }

    public Iterator<Expense> listExpenses() {
        return expenses.iterator();
    }

    public User getUser() {
        return user;
    }
}
