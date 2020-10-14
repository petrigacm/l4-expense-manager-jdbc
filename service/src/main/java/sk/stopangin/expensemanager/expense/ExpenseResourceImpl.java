package sk.stopangin.expensemanager.expense;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("expenses")
@RestController
public class ExpenseResourceImpl implements ExpenseResource {

    private ExpenseService expenseService;

    public ExpenseResourceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("{id}")
    @Override
    public Expense findById(@PathVariable("id") long id) {
        return expenseService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Expense create(@RequestBody Expense expense) {
        return expenseService.create(expense);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return "Oh no error";
    }
}
