package pageobjs;

import driver.DriverSingleton;
import helper.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utilities;

import java.time.Duration;
import java.util.function.Function;

public class AccountPage {

    private WebDriver driver;
    private Utilities utilities;

    public AccountPage() {
        driver = DriverSingleton.getDriver();
        utilities = new Utilities();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header//span[@class='logged-in'][contains(text(),'Welcome')]")
    private WebElement welcomeUserText;

    public String getWelcomeUserText() {
        return utilities.waitForElement(welcomeUserText).getText();
    }
}
