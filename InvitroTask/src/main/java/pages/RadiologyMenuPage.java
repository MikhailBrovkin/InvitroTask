package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Utils.click;

public class RadiologyMenuPage {
    private final WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class, 'second__list')]//a")
    private List<WebElement> sideBarItems;

    public RadiologyMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RadiologyMenuPage clickItem(WebElement element) {
        click(driver, element);
        return new RadiologyMenuPage(driver);
    }

    public List<WebElement> getSideBarItems() {
        return sideBarItems;
    }
}
