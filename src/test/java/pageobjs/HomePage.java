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
import utils.Utilities;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private Utilities utilities;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        utilities = new Utilities();
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

    @FindBy(xpath = "//header//a[contains(text(),'Sign In')]")
    private WebElement signInLink;

    public void addProductToCart(){
        utilities.waitForElement(firstProductSize).click();
        utilities.waitForElement(firstProductColor).click();

        Actions hover = new Actions(driver);
        hover.moveToElement(firstProduct).build().perform();
        firstProductAddToCartButton.click();
    }

    public void clickSignIn(){
        signInLink.click();
    }

    public String getAddedProductConfirmationMessage(){
        var message = utilities.waitForStaleElement(confirmationMessage);
        return message.getText();
    }

    public String getFirstProductName(){
        return firstProductName.getText();
    }

    public void clickCartLink(){
        cartLink.click();
    }

    public String getCartProductName(){
        return utilities.waitForElement(cartPopupProductName).getText();
    }
}
