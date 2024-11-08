package medunna.step_definitions.ui_step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import medunna.pages.HomePage;
import medunna.pages.TestItemPage;
import medunna.utilities.ConfigReader;
import medunna.utilities.Driver;
import medunna.utilities.WaitUtils;
import org.junit.Assert;

public class UIStepDefs {

    HomePage homePage = new HomePage();
    TestItemPage testItem = new TestItemPage();

    public static String name;
    public static String expectedDescription;
    public static String expectedPrice;
    public static String expectedMinValue;
    public static String expectedMaxValue;


    @Given("the user navigates to the {string} website")
    public void theUserNavigatesToTheWebsite(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
    }

    @When("the user clicks on the user icon")
    public void theUserClicksOnTheUserIcon() {
        homePage.userIcon.click();
    }

    @And("clicks on the sign in option")
    public void clicksOnTheSignInOption() {
        homePage.signInOption.click();
    }

    @And("enters the username in the username field")
    public void entersTheUsernameInTheUsernameField() {
        homePage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }

    @And("enters the password in the password field")
    public void entersThePasswordInThePasswordField() {
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }

    @And("clicks on the sign in button")
    public void clicksOnTheSignInButton() {
        homePage.signInSubmitButton.click();
    }

    @And("clicks on the Items and Titles option")
    public void clicksOnTheItemsAndTitlesOption() {
        homePage.itemsdAndTitles.click();
    }

    @And("clicks on the Test Item option")
    public void clicksOnTheTestItemOption() {
        homePage.testItemOption.click();
    }

    @And("clicks on the Create a new Test Item button")
    public void clicksOnTheCreateANewTestItemButton() {
        testItem.createANewTestItem.click();
    }

    @And("enters a name in the Name field")
    public void entersAInTheNameField() {
        name = new Faker().name().suffix();
        testItem.name.sendKeys(name);
    }

    @And("enters a {string} in the Description field")
    public void entersAInTheDescriptionField(String description) {
        testItem.description.sendKeys(description);
        expectedDescription = description;
    }

    @And("enters a {string} in the Price field")
    public void entersAInThePriceField(String price) {
        testItem.price.sendKeys(price);
        expectedPrice=price;
    }

    @And("enters a {string} in the Default Min. Value field")
    public void entersAInTheDefaultMinValueField(String min) {
        testItem.defaultValMin.sendKeys(min);
        expectedMinValue=min;
    }

    @And("enters a {string} in the Default Max. Value field")
    public void entersAInTheDefaultMaxValueField(String max) {
        testItem.defaultValMax.sendKeys(max);
        expectedMaxValue=max;
    }

    @And("clicks on the save button")
    public void clicksOnTheSaveButton() {
        testItem.saveButton.click();
    }


    @Then("verify A new Test Item is created succesfully")
    public void verifyANewTestItemIsCreatedSuccesfully() {
        WaitUtils.waitForVisibility(testItem.alert, 5);
        Assert.assertTrue(testItem.alert.isDisplayed());
    }

    @And("closes the application")
    public void closesTheApplication() {
        Driver.closeDriver();
    }
}
