package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.AnalyzesResultsPage;
import pages.MainPage;

import static driversetup.WebDriverSetup.getDriver;
import static org.junit.Assert.assertTrue;

public class CheckAnalyzesResultsSteps {
    private WebDriver driver;
    private MainPage mainPage;
    private AnalyzesResultsPage analyzesResultsPage;
    @Given("I go to analyzes results page")
    public void iGoToAnalyzesResultsPage() {
        driver = getDriver();
        try {
            this.driver.get("https://www.invitro.ru/");
        } catch (TimeoutException ignored) {}
        mainPage = new MainPage(driver);
        analyzesResultsPage = mainPage.openAnalyzesResults();
    }

    @Then("I click on find results")
    public void iClickOnFindResults() {
        analyzesResultsPage.clickResultsBtn();
    }

    @Then("I check red fields")
    public void iCheckRedFields() {
        assertTrue(analyzesResultsPage.checkRedFields());
    }

    @And("I check warning text")
    public void iCheckWarningText() {
        assertTrue(analyzesResultsPage.getWarningText().contains("Поля"));
        assertTrue(analyzesResultsPage.getWarningText().contains("Код ИНЗ"));
        assertTrue(analyzesResultsPage.getWarningText().contains("Дата рождения"));
        assertTrue(analyzesResultsPage.getWarningText().contains("Фамилия"));
        assertTrue(analyzesResultsPage.getWarningText().contains("обязательны для заполнения"));
        driver.close();
    }
}
