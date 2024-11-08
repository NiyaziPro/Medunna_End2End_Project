package medunna.pages;

import com.github.javafaker.Faker;
import medunna.utilities.Driver;
import medunna.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static medunna.utilities.WaitUtils.waitFor;
import static org.junit.Assert.*;

public class TestItemPage {
    public TestItemPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    Faker faker = new Faker();



    @FindBy( xpath = "//span[.='Create a new Test Item']")
    public WebElement createANewTestItem;

    @FindBy(id = "c-test-item-name")
    public WebElement name;

    @FindBy(id = "c-test-item-description")
    public WebElement description;

    @FindBy(id = "c-test-item-price")
    public WebElement price;

    @FindBy(id = "c-test-item-defaultValMin")
    public WebElement defaultValMin;

    @FindBy(id = "c-test-item-defaultValMax")
    public WebElement defaultValMax;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;

    @FindBy(className = "invalid-feedback")
    public WebElement requiredAlert;

    public void clickOnCreateANewTestItem(){
        this.createANewTestItem.click();
    }

    public void enterName(String name) {
        this.name.sendKeys(name);
    }
    public void enterDescription(String description) {
        this.description.sendKeys(description);
    }
    public void enterPrice(String price) {
        this.price.sendKeys(price);
    }

    public void enterDefaultValMin(String defaultValMin) {
        this.defaultValMin.sendKeys(defaultValMin);
    }
    public void enterDefaultValMax(String defaultValMax) {
        this.defaultValMax.sendKeys(defaultValMax);
    }

    public void clickOnSaveButton(){
        this.saveButton.click();
    }
    public void verifyItemCreation(String alert){
        WaitUtils.waitForVisibility(this.alert,10);
        System.out.println(this.alert.getText());
        assertTrue(this.alert.isDisplayed());
        assertTrue(this.alert.getText().contains(alert));

    }

    public void enterTestItemInfoWithFaker(){

        waitFor(1);
        enterName(faker.medical().medicineName());
        waitFor(1);
        enterDescription(faker.lorem().word());
        waitFor(1);
        enterPrice(faker.number().numberBetween(50,400)+"");
        waitFor(1);
        enterDefaultValMin(faker.number().numberBetween(10,50)+"");
        waitFor(1);
        enterDefaultValMax(faker.number().numberBetween(10,50)+"");

    }




    public void enterTestItemInfo(String name,String description,String price,String defaultValMin,String defaultValMax){

        waitFor(1);
        enterName(name);
        waitFor(1);
        enterDescription(description);
        waitFor(1);
        enterPrice(price);
        waitFor(1);
        enterDefaultValMin(defaultValMin);
        waitFor(1);
        enterDefaultValMax(defaultValMax);

    }

    public void verifyWithRequiredAlertMessage(){
       assertTrue(this.requiredAlert.isDisplayed());

    }


}
