package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Utils.click;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[contains(@class, 'city__btn')]")
    private WebElement cityBtn;

    @FindBy(xpath = "//a[contains(@class, 'city__change')]")
    private WebElement changeCityBtn;

    @FindBy(xpath = "//a[contains(@class, 'get_result')]")
    private WebElement resultsBtn;

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchInput;

    @FindBy(xpath = "//div/span[contains(@class,'city__name')]")
    private WebElement currentCity;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage clickCityBtn() {
        click(driver, cityBtn);
        return this;
    }

    public SearchCityPage clickChangeCityBtn() {
        if (!changeCityBtn.isDisplayed()) {
            clickCityBtn();
        }
        click(driver, changeCityBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'change')]")));
        return new SearchCityPage(driver);
    }

    public boolean checkCity(String city) {
        return cityBtn.getText().equals(city);
    }

    public AnalyzesResultsPage openAnalyzesResults() {
        click(driver, resultsBtn);
        return new AnalyzesResultsPage(driver);
    }

    public SearchResultsPage search(String string) {
        searchInput.clear();
        new Actions(driver).sendKeys(searchInput, string).build().perform();
        searchInput.submit();
        return new SearchResultsPage(driver);
    }

    public void clickChapter(String chapter) {
        WebElement chapterElement = driver.findElement(
                By.xpath("//li[contains(@class,'menu_main')]/a[contains(text(),'" + chapter + "')]"));
        click(driver, chapterElement);
    }

    public String getCurrentCity() {
        return currentCity.getText();
    }
}
