package sk.stopangin.expensemanager.expense;

import java.util.List;

public interface ExpenseRepository {

    Expense create(Expense expense);

    List<Expense> create(List<Expense> expenses);

    Expense update(long id, Expense expense);

    void deleteById(long id);

    Expense findById(long id);

    List<Expense> findByAmountGreaterThan(double amount);

}
