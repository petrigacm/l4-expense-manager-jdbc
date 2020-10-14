package sk.stopangin.expensemanager.expense;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ExpenseRepositoryJdbcImpl implements ExpenseRepository {

    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    public ExpenseRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionManager = transactionManager;
    }

    @Override
    public Expense create(Expense expense) {
        jdbcTemplate.update("INSERT INTO expense (id, amount, description) " +
                "VALUES (?, ?, ?)", expense.getId(), expense.getAmount(), expense.getDescription());

        return this.findById(expense.getId());
    }

    @Override
    public List<Expense> create(List<Expense> expenses) {
        TransactionDefinition transactionDefinition = TransactionDefinition.withDefaults();

        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

        try {
            List<Expense> result = expenses.stream()
                    .map(this::create)
                    .collect(Collectors.toList());

            transactionManager.commit(transactionStatus);

            return result;

        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            return Collections.emptyList();
        }
    }

    @Override
    public Expense update(long id, Expense expense) {
        jdbcTemplate.update("UPDATE expense SET amount=?, description=? WHERE id=?",
                expense.getAmount(), expense.getDescription(), id);

        return this.findById(id);
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("DELETE FROM expense WHERE id = ?", id);
    }

    @Override
    public Expense findById(long id) {
        List<Expense> expenses = jdbcTemplate.query("SELECT id, amount, description FROM expense WHERE id = ?", expenseRowMapper, id);

        if (expenses.isEmpty()) {
            return null;
        } else {
            return expenses.get(0);
        }
    }

    @Override
    public List<Expense> findByAmountGreaterThan(double amount) {
        return jdbcTemplate.query("SELECT * FROM expense WHERE amount > ?", expenseRowMapper, amount);
    }

    RowMapper<Expense> expenseRowMapper = new RowMapper<Expense>() {
        @Override
        public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
            Expense expense = new Expense();
            expense.setId(rs.getLong("id"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setDescription(rs.getString("description"));
            return expense;
        }
    };
}
