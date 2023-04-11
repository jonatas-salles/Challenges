package org.example;

import java.util.Iterator;

public class Report {
    public void listExpensesByCategory(Iterator<Expense> expenses, ExpenseCategory.Category category) {
        while (expenses.hasNext()) {
            Expense expense = expenses.next();
            if (expense.getCategory() == category) {
                System.out.println(expense.toString());
            }
        }
    }

    public void listAllExpenses(Iterator<Expense> expenses) {
        while (expenses.hasNext()) {
            System.out.println(expenses.next().toString());
        }
    }
}