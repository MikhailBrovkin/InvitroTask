package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.SearchResultsPage;

import static driversetup.WebDriverSetup.getDriver;
import static org.junit.Assert.assertTrue;

public class ParametrizedSteps {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;

    @Given("Go to main page")
    public void goToMainPage() {
        driver = getDriver();
        try {
            driver.get("https://www.invitro.ru/");
        } catch (TimeoutException ignored) {}
        mainPage = new MainPage(driver);
    }

    @When("I write in the search field {string}")
    public void iWriteInTheSearchField(String search) {
        searchResultsPage = mainPage.search(search);
    }

    @Then("I get result")
    public void iGetResult() {
        assertTrue(driver.getTitle().contains("Поиск"));
        driver.close();
    }
}
