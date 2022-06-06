package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultsPage;

import static driversetup.WebDriverSetup.getDriver;
import static org.junit.Assert.assertTrue;

public class ComparePricesSteps {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;
    private CartPage cartPage;

    @Given("I'm in main page")
    public void iMInMainPage() {
        driver = getDriver();
        try {
            driver.get("https://www.invitro.ru/");
        } catch (TimeoutException ignored) {}
        mainPage = new MainPage(driver);
    }

    @When("I search {string} product")
    public void iSearchProduct(String product) {
        searchResultsPage = mainPage.search(product);
        assertTrue(searchResultsPage.checkSearchWithNumber(product));
    }

    @And("I will keep his price")
    public void iWillKeepHisPrice() {
        searchResultsPage.saveProductPrice();
    }

    @And("I add it to cart")
    public void iAddItToCart() {
        searchResultsPage.addToCart();
    }

    @And("I go to cart")
    public void iGoToCart() {
        cartPage = searchResultsPage.goToCart();
    }

    @Then("I compare their prices")
    public void iCompareTheirPrices() {
        assertTrue(cartPage.comparePrices());
        driver.close();
    }
}
