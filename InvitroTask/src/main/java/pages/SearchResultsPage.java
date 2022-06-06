package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.click;

public class SearchResultsPage {
    private WebDriver driver;
    private static String savedProductPrice;

    @FindBy(xpath = "//div[contains(@class,'result-num')]/span")
    private WebElement analysisNumber;

    @FindBy(xpath = "//div[contains(@class,'meta-price')]")
    private WebElement productPrice;

    @FindBy(xpath = "//div[contains(@class,'meta-button')]/a")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[contains(@class,'cart row')]//a")
    private WebElement cartBtn;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkSearchWithNumber(String search) {
        return analysisNumber.getText().equals(search);
    }

    public void saveProductPrice() {
        savedProductPrice = productPrice.getText().replaceAll("\\D", "");
    }

    public static String getSavedProductPrice() {
        return savedProductPrice;
    }

    public SearchResultsPage addToCart() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
        click(driver, addToCartBtn);
        return this;
    }

    public CartPage goToCart() {
        click(driver, cartBtn);
        return new CartPage(driver);
    }

}
