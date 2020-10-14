package sk.stopangin.expensemanager.expense;

import java.util.List;

public interface ExpenseService {

    Expense findById(long id);

    Expense create(Expense expense);

    List<Expense> create(List<Expense> expense);

    Expense update(long id, Expense expense);

    void delete(long id);

    List<Expense> findByAmountGreaterThan(double amount);

    double getSumOfExpensesWithAmountGreaterThan(double amount);

}
