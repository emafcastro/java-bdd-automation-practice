package steps;

import driver.DriverSingleton;
import helper.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjs.AccountPage;
import pageobjs.HomePage;
import pageobjs.SignInPage;
import utils.FrameworkProperties;
import utils.context.Context;
import utils.context.ScenarioContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private AccountPage accountPage;
    private ScenarioContext scenarioContext;

    @Before
    public void initializeObjects() {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        homePage = new HomePage();
        signInPage = new SignInPage();
        accountPage = new AccountPage();
        scenarioContext = ScenarioContext.getInstance();
    }

    @After
    public void tearDown() {
        DriverSingleton.closeObjectInstance();
    }

    @Given("the customer navigates to the Website")
    public void the_customer_navigates_to_the_website() {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @When("the customer clicks on Sign In button")
    public void the_customer_clicks_on_sign_in_button() {
        homePage.clickSignIn();
    }

    @When("the customer adds a product to the cart")
    public void the_customer_adds_a_product_to_the_cart() {
        homePage.addProductToCart();
        scenarioContext.setContext(Context.PRODUCT_NAME, homePage.getFirstProductName());
    }

    @And("the customer specifies their credentials and click Login")
    public void the_customer_specifies_their_credentials_and_click_login() {
        signInPage.logIn("h9r8kr49n1@paperpapyrus.com", "Automation!");
    }

    @Then("the customer can log into the website")
    public void the_customer_can_log_into_the_website() {
        assertTrue(accountPage.getWelcomeUserText().contains("Test Automation"));
    }

    @Then("a message about the added element is displayed")
    public void a_message_about_the_added_element_is_displayed() {
        String productName = (String)scenarioContext.getContext(Context.PRODUCT_NAME);
        assertTrue(homePage.getAddedProductConfirmationMessage().contains(productName));
    }

    @And("the product can be seen in the cart popup")
    public void the_product_can_be_seen_in_the_cart_popup() {
        homePage.clickCartLink();
        String productName = (String)scenarioContext.getContext(Context.PRODUCT_NAME);
        assertTrue(homePage.getCartProductName().contains(productName));
    }
}
