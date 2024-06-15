package glue;

import account.Account;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AccountSteps {



        private Account account;
        private String statement;

        @Given("Account exists for Acc No. {string} with Name {string}")
        public void accountExists(String accountNumber, String name) {
            account = new Account(accountNumber, name);
        }

        @Given("deposits are made")
        public void depositsAreMade(io.cucumber.datatable.DataTable dataTable) {
            Map<String, Double> deposits = dataTable.asMap(String.class, Double.class);
            for (Map.Entry<String, Double> deposit : deposits.entrySet()) {
                account.deposit(deposit.getKey(), deposit.getValue());
            }
        }

        @Given("withdrawals are made")
        public void withdrawalsAreMade(io.cucumber.datatable.DataTable dataTable) {
            Map<String, Double> withdrawals = dataTable.asMap(String.class, Double.class);
            for (Map.Entry<String, Double> withdrawal : withdrawals.entrySet()) {
                account.withdraw(withdrawal.getKey(), withdrawal.getValue());
            }
        }

        @When("statement is produced")
        public void statementIsProduced() {
            statement = account.generateStatement();
        }

        @Then("statement includes {string}")
        public void statementIncludes(String expectedContent) {
            assertTrue(statement.contains(expectedContent));
        }

    @And("withdrawls are made")
    public void withdrawlsAreMade(io.cucumber.datatable.DataTable dataTable) {
        Map<String, Double> withdrawals = dataTable.asMap(String.class, Double.class);
        for (Map.Entry<String, Double> withdrawal : withdrawals.entrySet()) {
            account.withdraw(withdrawal.getKey(), withdrawal.getValue());
        }

    }
}