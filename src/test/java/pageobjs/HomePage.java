package pageobjs;

import driver.DriverSingleton;
import helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='product-item'][1]")
    private WebElement firstProduct;

    @FindBy(xpath = "//li[@class='product-item'][1]//div[contains(@aria-describedby,'option-label-size')][1]")
    private WebElement firstProductSize;

    @FindBy(xpath = "//li[@class='product-item'][1]//div[contains(@aria-describedby,'option-label-color')][1]")
    private WebElement firstProductColor;

    @FindBy(xpath = "//li[@class='product-item'][1]//strong[@class='product-item-name']/a")
    private WebElement firstProductName;

    @FindBy(xpath = "//li[@class='product-item'][1]//button[@title='Add to Cart']")
    private WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//div[@role='alert']/div/div")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//div[@data-block='minicart']/a[contains(@href,'cart')]")
    private WebElement cartLink;

    @FindBy(xpath = "//div[@id='minicart-content-wrapper']//strong[@class='product-item-name']/a")
    private WebElement cartPopupProductName;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement cartPopupProceedToCheckoutButton;

    public void addProductToCart(){
        firstProductSize.click();
        firstProductColor.click();

        Actions hover = new Actions(driver);
        hover.moveToElement(firstProduct).build().perform();
        firstProductAddToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        System.out.println(confirmationMessage.getText());
    }
}
