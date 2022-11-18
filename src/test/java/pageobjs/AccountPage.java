package pageobjs;

import driver.DriverSingleton;
import helper.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class AccountPage {

    private WebDriver driver;

    public AccountPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header//span[@class='logged-in']")
    private WebElement welcomeUserText;

    public String getWelcomeUserText() {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Constants.LARGE_TIMEOUT)).pollingEvery(Duration.ofSeconds(Constants.SHORT_TIMEOUT)).ignoring(StaleElementReferenceException.class);
        wait.until(webDriver -> driver.findElement(By.xpath("//header//span[@class='logged-in']")));
        return welcomeUserText.getText();
    }
}
