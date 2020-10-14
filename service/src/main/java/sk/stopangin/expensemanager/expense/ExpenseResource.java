package sk.stopangin.expensemanager.expense;

public interface ExpenseResource {
    Expense findById(long id);

    Expense create(Expense expense);
}
