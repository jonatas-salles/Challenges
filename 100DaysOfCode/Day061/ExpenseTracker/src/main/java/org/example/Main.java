package org.example;

public class Main {
    public static void main(String[] args) {
        User user = new User("Jorge");
        ExpenseTracker userTracker = new ExpenseTracker(user);
        Report report = new Report();

        Expense expense1 = new Expense(19.90, ExpenseCategory.Category.FOOD, "Fast food");
        Expense expense2 = new Expense(199.99, ExpenseCategory.Category.TRANSPORT, "Flight");
        Expense expense3 = new Expense(60.15, ExpenseCategory.Category.ENTERTAINMENT, "Park pass");
        Expense expense4 = new Expense(39.99, ExpenseCategory.Category.OTHER, "Donation");

        userTracker.addExpense(expense1);
        System.out.println("User expenses after adding expense1:\n");
        report.listAllExpenses(userTracker.listExpenses());

        userTracker.addExpense(expense4);
        System.out.println("User expenses filtered by category OTHER after adding expense4:\n");
        report.listExpensesByCategory(userTracker.listExpenses(), ExpenseCategory.Category.OTHER);

        userTracker.addExpense(expense2);
        userTracker.addExpense(expense3);
        System.out.println("User expenses after adding one of each expenses:\n");
        report.listAllExpenses(userTracker.listExpenses());

        Expense expense5 = new Expense(5.99, ExpenseCategory.Category.FOOD, "Milk shake");
        userTracker.addExpense(expense5);
        System.out.println("User expenses after adding expense5 filtered by category FOOD:\n");
        report.listExpensesByCategory(userTracker.listExpenses(), ExpenseCategory.Category.FOOD);

        userTracker.removeExpense(expense1);
        userTracker.removeExpense(expense2);
        userTracker.removeExpense(expense3);
        userTracker.removeExpense(expense4);
        System.out.println("User expenses after removing all expenses but expense5");
        report.listAllExpenses(userTracker.listExpenses());

    }
}
