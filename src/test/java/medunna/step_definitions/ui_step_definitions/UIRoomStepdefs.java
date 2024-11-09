package medunna.step_definitions.ui_step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

import org.junit.Assert;
import medunna.pages.MedunnaPage;
import medunna.utilities.*;

public class UIRoomStepdefs {

    public static int roomNumber;
    public static String expectedRoomDescription;
    public static Integer expectedRoomPrice;
    MedunnaPage medunnaPage = new MedunnaPage();

    @And("clicks on the room option")
    public void clicksOnTheRoomOption() {
        medunnaPage.roomOption.click();
    }

    @And("click on the Create a new room button")
    public void clickOnTheCreateANewRoomButton() {
        medunnaPage.createANewRoomButton.click();
    }

    @And("enters a room number in the room number field")
    public void entersARoomNumberInTheRoomNumberField() {
        roomNumber = Faker.instance().number().numberBetween(100000, 1000000);
        medunnaPage.roomNumberInput.sendKeys(roomNumber + "");
    }

    @And("selects SUITE from the room type menu")
    public void selectsSUITEFromTheRoomTypeMenu() {
        BrowserUtils.dropdownSelectByVisibleText(medunnaPage.roomTypeDropDown, "SUITE");
    }


    @And("clicks on the status checkbox")
    public void clicksOnTheStatusCheckbox() {
        medunnaPage.statusCheckBox.click();
    }

    @And("enters {string} in the Price field")
    public void entersInThePriceField(String price) {

        medunnaPage.priceInput.sendKeys(price);
        expectedRoomPrice = Integer.valueOf(price);

    }

    @And("enters a {string} in the description field")
    public void entersAInTheDescriptionField(String description) {
        medunnaPage.descriptionInput.sendKeys(description);
        expectedRoomDescription=description;
    }


    @Then("verify A new Room is created succesfully")
    public void verifyANewRoomIsCreatedSuccesfully() {
        WaitUtils.waitForVisibility(medunnaPage.alert, 5);
        Assert.assertTrue(medunnaPage.alert.isDisplayed());
    }
}
