package pageobjs;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(xpath = "//main[@id='maincontent']//a/span[text()='Create an Account']")
    private WebElement createAccountButton;

    public void logIn(String email, String pass){
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        signInButton.click();
    }

    public void clickSignUp(){
        createAccountButton.click();
    }
}
