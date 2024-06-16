package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static glue.W.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GoogleSteps {
   // private String url;

    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }

    private static void acceptCookiesIfWarned() {
        try {
            W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
        } catch (NoSuchElementException ignored) {
        }
    }
    private WebDriver driver = get().driver;

//    @Given("url {string} is launched")
//    public void urlIsLaunched(String url) {
//        driver.get(url);
//    }

    @When("About page is shown")
    public void aboutPageIsShown() {
        WebElement aboutLink = driver.findElement(By.xpath("//a[text()='About']"));
        aboutLink.click();
    }

    @Then("page displays {string}")
    public void pageDisplays(String expectedText) {
        assertTrue(driver.getPageSource().contains(expectedText));
    }

    @When("searching for {string}")
    public void searchingFor(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    @Then("results contain {string}")
    public void resultsContain(String expectedText) {
        List<WebElement> results = driver.findElements(By.xpath("//h3"));
        boolean found = results.stream().anyMatch(result -> result.getText().contains(expectedText));
        assertTrue(found);
    }

    @Then("result stats are displayed")
    public void resultStatsAreDisplayed() {
        WebElement resultStats = driver.findElement(By.id("result-stats"));
        assertNotNull(resultStats);
    }

    @Then("number of {string} is more than {int}")
    public void numberOfIsMoreThan(String type, int minValue) {
        WebElement resultStats = driver.findElement(By.id("result-stats"));
        String statsText = resultStats.getText();

        if (type.equals("results")) {
            String resultsNumber = statsText.split(" ")[1].replace(",", "");
            assertTrue(Integer.parseInt(resultsNumber) > minValue);
        } else if (type.equals("seconds")) {
            String secondsString = statsText.split(" ")[3].replace("(", "").replace(")", "").replace("s", "");
            assertTrue(Double.parseDouble(secondsString) > minValue);
        }
    }
}