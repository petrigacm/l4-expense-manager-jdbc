package sk.stopangin.expensemanager.expense;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense findById(long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public Expense create(Expense expense) {
        return expenseRepository.create(expense);
    }

    @Override
    public List<Expense> create(List<Expense> expense) {
        return expenseRepository.create(expense);
    }

    @Override
    public Expense update(long id, Expense expense) {
        return expenseRepository.update(id, expense);
    }

    @Override
    public void delete(long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> findByAmountGreaterThan(double amount) {
        return expenseRepository.findByAmountGreaterThan(amount);
    }

    @Override
    public double getSumOfExpensesWithAmountGreaterThan(double amount) {
        return this.findByAmountGreaterThan(amount)
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
