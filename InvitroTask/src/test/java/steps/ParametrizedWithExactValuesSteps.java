package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static driversetup.WebDriverSetup.getDriver;
import static org.junit.Assert.assertTrue;

public class ParametrizedWithExactValuesSteps {
    private WebDriver driver;
    private MainPage mainPage;

    @Given("Main page")
    public void mainPage() {
        driver = getDriver();
        try {
            driver.get("https://www.invitro.ru/");
        } catch (TimeoutException ignored) {}
        mainPage = new MainPage(driver);
    }

    @And("My city is {string}")
    public void myCityIs(String city) {
        if (!mainPage.getCurrentCity().equals(city)) {
            try {
                mainPage.clickChangeCityBtn()
                        .setCity(city)
                        .selectCity();
            } catch (TimeoutException ignored) {}
        }
        assertTrue(mainPage.checkCity(city));
    }

    @Then("I click on {string}")
    public void iClickOnChapter(String chapter) {
        mainPage.clickChapter(chapter);
        driver.close();
    }
}
