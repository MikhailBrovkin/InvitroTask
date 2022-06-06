package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.click;

public class AnalyzesResultsPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'recaptcha-checkbox-border']")
    private WebElement captchaCheckbox;

    @FindBy(xpath = "//div[contains(@class,'ResultsBlock')]/button")
    private WebElement findResultsBtn;

    @FindBy(xpath = "//input[@name = 'orderNumber']")
    private WebElement orderNumberInput;

    @FindBy(xpath = "//input[@name = 'birthday']")
    private WebElement birthdayInput;

    @FindBy(xpath = "//input[@name = 'lastName']")
    private WebElement lastnameInput;

    @FindBy(xpath = "//div[contains(@class,'Page_error')]")
    private WebElement warningElements;

    public AnalyzesResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AnalyzesResultsPage clickResultsBtn() {
        click(driver, findResultsBtn);
        return this;
    }

    public boolean checkRedFields() {
        this.orderNumberInput.clear();
        this.lastnameInput.clear();
        this.birthdayInput.clear();
        return orderNumberInput.getAttribute("class").contains("error")
                && birthdayInput.getAttribute("class").contains("error")
                && lastnameInput.getAttribute("class").contains("error");
    }

    public String getWarningText() {
        return warningElements.getText();
    }
}
