package medunna.step_definitions.ui_step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import medunna.pages.HomePage;
import medunna.pages.TestItemPage;
import medunna.utilities.ConfigReader;
import medunna.utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewUIStepdefs {
    HomePage homePage = new HomePage();
    TestItemPage testItemPage = new TestItemPage();

    @Given("the user logs into the {string} page as admin")
    public void theUserLogsIntoThePageAs(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        homePage.login();
    }

    @And("Goes to the Test Item page from Items&Titles and clicks Create new Test Item")
    public void goesToTheTestItemPageFromItemsTitlesAndClicksCreateNewTestItem() {
        homePage.clickOnItemsdAndTitles();
        homePage.clickOnTestItemOption();
        testItemPage.clickOnCreateANewTestItem();

    }

    @And("enters valid data into fields and clicks on the Save button")
    public void entersValidDataIntoFieldsAndClicksOnTheSaveButton() {
        testItemPage.enterTestItemInfoWithFaker();
        testItemPage.clickOnSaveButton();
    }

    @Then("Verifies that the Test Item has been created and displays the message {string}")
    public void verifiesThatTheTestItemHasBeenCreatedAndDisplaysTheMessage(String message) {
        testItemPage.verifyItemCreation(message);
    }

    @And("Test Item is created with the following data: name {string}, description {string}, price {string} , minValue {string}, maxValue {string}")
    public void testItemIsCreatedWithTheFollowingDataNameDescriptionPriceMinValueMaxValue(String name, String description, String price, String minValue, String maxValue) {
        testItemPage.enterTestItemInfo(name,description,price,minValue,maxValue);
        testItemPage.clickOnSaveButton();

    }

    @And("enters into fields the following data: name {string}, description {string}, price {string}, minValue {string}, maxValue {string}")
    public void entersIntoFieldsTheFollowingDataNameDescriptionPriceMinValueMaxValue(String name, String description, String price, String minValue, String maxValue) {
        testItemPage.enterTestItemInfo(name,description,price,minValue,maxValue);
        testItemPage.clickOnSaveButton();
    }

    @Then("verifies that the Test Item has not been created")
    public void verifiesThatTheTestItemHasNotBeenCreated() {
       testItemPage.verifyWithRequiredAlertMessage();

    }
}
