package glue;

import account.Account;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AccountSteps {
    private int balance;
    String accountName;
    String accountNumber;

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String number, String name) {
        accountName= name;
        accountNumber = number;
    }



    @Given("deposits are made")
    public void deposits_are_made(DataTable dataTable) {
        List<Map<String, String>> deposits = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> deposit : deposits) {
            int amount = Integer.parseInt(deposit.get("amount"));
            String account = deposit.get("account");
            System.out.println("account"+account);
            System.out.println("amount"+amount);
            Account.deposit(account,amount);
        }

    }
    @Given("withdrawls are made")
    public void withdrawls_are_made(DataTable dataTable) {
        List<Map<String, String>> deposits = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> deposit : deposits) {
            int amount = Integer.parseInt(deposit.get("amount"));
            balance -= amount;
        }
    }
    @When("statement is produced")
    public void statement_is_produced() {
        System.out.println("print balance==="+balance);
    }
    @Then("statement includes {string}")
    public void statement_includes(String string) {

    }




}
