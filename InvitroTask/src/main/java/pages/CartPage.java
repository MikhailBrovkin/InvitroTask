package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'Price')]/span")
    private WebElement priceInCart;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean comparePrices() {
        return priceInCart.getText().replaceAll("\\D", "").equals(SearchResultsPage.getSavedProductPrice());
    }
}
