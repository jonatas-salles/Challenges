package org.example;

public class Expense {
    private final double price;
    private final ExpenseCategory.Category category;
    private final String description;

    public Expense(double price, ExpenseCategory.Category category, String description) {
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public ExpenseCategory.Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "price=" + price + "\n" +
                "category=" + category + " \n" +
                "description='" + description + '\'' +
                '\n';
    }
}
