package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.RadiologyMenuPage;

import static driversetup.WebDriverSetup.getDriver;

public class ClickAllMenuItemsSteps {
    private WebDriver driver;
    private RadiologyMenuPage radiologyMenuPage;

    @Given("I go to the section Medical services")
    public void iGoToSectionMedicalServices() {
        driver = getDriver();
        try {
            driver.get("https://www.invitro.ru/radiology/");
        } catch (TimeoutException ignored) {}
        radiologyMenuPage = new RadiologyMenuPage(driver);
    }

    @Then("I click all items on left menu")
    public void iClickAllItemsOnLeftMenu() {
        for (int i = 0; i < radiologyMenuPage.getSideBarItems().size(); i++) {
            radiologyMenuPage.clickItem(radiologyMenuPage.getSideBarItems().get(i));
        }
        driver.close();
    }

}
