package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.SearchCityPage;

import static driversetup.WebDriverSetup.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChangeCitySteps {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchCityPage searchCityPage;

    @Given("I go to main page")
    public void iGoToMainPage() {
        driver = getDriver();
        try {
            driver.get("https://www.invitro.ru/");
        } catch (TimeoutException ignored) {}
        mainPage = new MainPage(driver);
    }

    @When("I click to choose another city")
    public void iClickToChooseAnotherCity() {
        searchCityPage = mainPage.clickChangeCityBtn();
    }

    @And("I write in search {string}")
    public void iWriteInSearch(String city) {
        searchCityPage.setCity(city);
    }

    @And("I check that the search is correct and contains {string}")
    public void iCheckThatTheSearchIsCorrectAndContains(String city) {
        assertEquals(searchCityPage.getFoundCity(), city);
    }

    @And("I choose city")
    public void iChooseCity() {
        mainPage = searchCityPage.selectCity();
    }

    @Then("I see {string} city on the main page")
    public void iSeeCityOnTheMainPage(String city) {
        assertTrue(mainPage.checkCity(city));
        driver.close();
    }
}
