package utils;

import driver.DriverSingleton;
import helper.Constants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class Utilities {
    private WebDriver driver;
    public Utilities(){
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        driver = DriverSingleton.getDriver();
    }
    public WebElement waitForElement(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Constants.LARGE_TIMEOUT)).pollingEvery(Duration.ofSeconds(Constants.SHORT_TIMEOUT)).ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForStaleElement(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Constants.LARGE_TIMEOUT)).pollingEvery(Duration.ofSeconds(Constants.SHORT_TIMEOUT)).ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
