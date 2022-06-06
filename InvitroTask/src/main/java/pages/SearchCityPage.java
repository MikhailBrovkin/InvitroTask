package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.click;

public class SearchCityPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@class, 'change')]")
    private WebElement inputCity;

    @FindBy(xpath = "//div[contains(@class, 'eac-item')]/b")
    private WebElement foundCity;

    @FindBy(xpath = "//div[contains(@class, 'eac-item')]")
    private WebElement selectCity;

    public SearchCityPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchCityPage setCity(String city) {
        inputCity.clear();
        new Actions(driver).sendKeys(inputCity, city).build().perform();
        return this;
    }

    public String getFoundCity() {
        return foundCity.getText();
    }

    public MainPage selectCity() {
        click(driver, selectCity);
        return new MainPage(driver);
    }
}
